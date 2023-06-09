
package swp391.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import swp391.customer.CustomerDTO;
import swp391.orders.OrdersDAO;
import swp391.orders.OrdersDTO;
import swp391.utils.MyApplicationConstants;

/**
 *
 * @author Duy
 */
@WebServlet(name = "CustomerOrdersListServlet", urlPatterns = {"/CustomerOrdersListServlet"})
public class CustomerOrdersListServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        HttpSession session = request.getSession();
        CustomerDTO user = (CustomerDTO) session.getAttribute("USER");
        OrdersDAO ordersDAO = new OrdersDAO();
        String url = siteMaps.getProperty(
                MyApplicationConstants.CustomerOrdersList.CUSTOMER_ORDERS_LIST_PAGE);
        try {
            List<OrdersDTO> listOrders = ordersDAO.getListOrdersByCusId(user.getCustomerID());
            if (listOrders != null) {
                request.setAttribute("ORDERS_LIST_FOR_USER", listOrders);
                url = siteMaps.getProperty(
                        MyApplicationConstants.CustomerOrdersList.CUSTOMER_ORDERS_LIST_PAGE);
            }

        } catch (NamingException ex) {
            log("AdminAccountListServlet _ Naming _ " + ex.getMessage());
        } catch (SQLException ex) {
            log("AdminAccountListServlet _ SQL _ " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
