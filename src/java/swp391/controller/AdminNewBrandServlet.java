/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
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
import swp391.brand.BrandDAO;
import swp391.brand.BrandDTO;
import swp391.utils.MyApplicationConstants;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "AdminNewBrandServlet", urlPatterns = {"/AdminNewBrandServlet"})
public class AdminNewBrandServlet extends HttpServlet {

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
        String url = siteMaps.getProperty(
                MyApplicationConstants.AdminNewBrandServlet.ADMINBRANDLIST_PAGE);
        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("USER") == null) {
            response.sendRedirect(siteMaps.getProperty(
                MyApplicationConstants.LoginServlet.LOGIN_PAGE));
            return;
        }
        String name = request.getParameter("txtName");
        String description = request.getParameter("txtDescription");
        byte[] bytes1 = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes1, StandardCharsets.UTF_8);
        byte[] bytes2 = description.getBytes(StandardCharsets.ISO_8859_1);
        description = new String(bytes2, StandardCharsets.UTF_8);
            String statusParam = request.getParameter("status");
    boolean status = Boolean.parseBoolean(statusParam);

        try {
            BrandDAO dao = new BrandDAO();
            BrandDTO dto = new BrandDTO(name, description,status);
            boolean result = dao.createBrand(dto);
            if (result) {
                url = siteMaps.getProperty(
                        MyApplicationConstants.AdminNewBrandServlet.ADMINBRANDLIST_PAGE);
            }
        } catch (NamingException ex) {
            log("AdminNewBrandServlet _ Naming _ " + ex.getMessage());
        } catch (SQLException ex) {
            log("AdminNewBrandServlet _ SQL _ " + ex.getMessage());
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
