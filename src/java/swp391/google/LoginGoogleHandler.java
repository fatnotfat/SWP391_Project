package swp391.google;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import swp391.cart.CartDAO;
import swp391.cart.CartDTO;
import swp391.cart.CartObject;
import swp391.category.CategoryDAO;
import swp391.category.CategoryDTO;
import swp391.customer.CustomerDAO;
import swp391.customer.CustomerDTO;
import swp391.orders.OrdersDAO;
import swp391.orders.OrdersDTO;
import swp391.product.ProductDAO;
import swp391.product.ProductDTO;
import swp391.utils.MyApplicationConstants;

/**
 * @author heaty566
 */
@WebServlet(urlPatterns = {"/LoginGoogleHandler"})
public class LoginGoogleHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(
                MyApplicationConstants.FirstTimeRequestServlet.LOGIN_PAGE);
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDTO user = getUserInfo(accessToken);
        System.out.println(user);
        if (user != null) {
            try {
                String name = user.getName();
//                byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
//                name = new String(bytes, StandardCharsets.UTF_8);
                String email = user.getEmail();
                //1.Call dao
                CustomerDAO dao = new CustomerDAO();
                ProductDAO productDao = new ProductDAO();
                CategoryDAO categoryDao = new CategoryDAO();
                if (!dao.checkEmail(email)) {
                    //TH1: Check trc neu chua ton tai email thi tu dang ky tai khoan

                    CustomerDTO dto
                            = new CustomerDTO(name, "none", null, email,
                                    "none", "none", false, 1, false, 1);
                    boolean result = dao.createAccount(dto);
                    if (result) {
                        url = siteMaps.getProperty(
                                MyApplicationConstants.ShowMainPageServlet.MAIN_PAGE);
                        HttpSession session = request.getSession();
                        session.setAttribute("USER", dto);
                    }
                } else if (dao.checkEmail(email)) {
                    //TH2: Check trc neu nhu email da ton tai, thi:
                    if (dao.checkEmailAlreadyRegister(email) != null) {
                        //Check xem dang nhap binh thuong hay dang nhap bang google
                        //Neu nhu email nay da dang ki va hinh thuc dang nhap bang google thi vao thang main page
                        url = siteMaps.getProperty(
                                MyApplicationConstants.ShowMainPageServlet.MAIN_PAGE);
                        HttpSession session = request.getSession();
                        session.setAttribute("USER", dao.checkEmailAlreadyRegister(email));
                        CartDAO cartDao = new CartDAO();
                        CartObject cartObject = new CartObject();
                        CustomerDTO result = dao.checkEmailAlreadyRegister(email);
                        List<CartDTO> list = cartDao.getCart(result.getCustomerID());
                        OrdersDAO ordersDAO = new OrdersDAO();
                        List<OrdersDTO> customerOrders = ordersDAO.getCustomerShippingInFoByCusID(result.getCustomerID());
                        session.setAttribute("USER_SHIPPINGINFO", customerOrders);

                        List<OrdersDTO> listOrders = ordersDAO.getTopOneOrdersByCusId(result.getCustomerID());
                        session.setAttribute("ORDERS_LIST_OF_USER", listOrders);
                        
                        if (list != null) {
                            cartObject.insertToCartUser(list);
                        }
                        session.setAttribute("CART", cartObject);
                        //get newest product
                        List<ProductDTO> productList = productDao.getNewestProduct();
                        session.setAttribute("NEWEST_PRODUCT", productList);
                        List<ProductDTO> productList2 = productDao.getSecondNewestProduct();
                        session.setAttribute("SECOND_NEWEST_PRODUCT", productList2);
                        List<CategoryDTO> categoryList = categoryDao.getListCategory();
                        session.setAttribute("CATEGORY", categoryList);
                    } else {
                        //neu nhu dang nhap binh thuong thi khong cho dang nhap
                        url = siteMaps.getProperty(
                                MyApplicationConstants.LoginServlet.LOGIN_PAGE);
                        HttpSession session = request.getSession();
                        request.setAttribute("EMAIL_EXIST", "Email was existed!!");
                    }
                }
            } catch (ParseException ex) {
                log("LoginGoogle _ Parse _ " + ex.getMessage());
            } catch (SQLException ex) {
                log("LoginGoogle _ SQL _ " + ex.getMessage());
            } catch (NamingException ex) {
                log("LoginGoogle _ Naming _ " + ex.getMessage());
            } finally {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
//                response.sendRedirect(url);
            }
        }
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        System.out.println(accessToken);
        return accessToken;
    }

    public static UserGoogleDTO getUserInfo(final String accessToken)
            throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        System.out.println(response);
        UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);

        System.out.println(googlePojo.getName());
        return googlePojo;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
    // sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
