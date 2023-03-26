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
import swp391.category.CategoryDAO;
import swp391.utils.MyApplicationConstants;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "AdminUpdateCategoryServlet", urlPatterns = {"/AdminUpdateCategoryServlet"})
public class AdminUpdateCategoryServlet extends HttpServlet {

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
                MyApplicationConstants.AdminUpdateCategoryServlet.ADMINCATEGORYLIST_PAGE);
        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("USER") == null) {
            response.sendRedirect(siteMaps.getProperty(
                MyApplicationConstants.LoginServlet.LOGIN_PAGE));
            return;
        }
        String txtCategoryID = request.getParameter("categoryIdUpdate");
        int categoryID = Integer.parseInt(txtCategoryID);
        String name = request.getParameter("name");
        byte[] bytes1 = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes1, StandardCharsets.UTF_8);
        String description = request.getParameter("description");
        byte[] bytes2 = description.getBytes(StandardCharsets.ISO_8859_1);
        description = new String(bytes2, StandardCharsets.UTF_8);
             String statusParam = request.getParameter("status");
        boolean status = Boolean.parseBoolean(statusParam);
        System.out.println("StatusCategory: " + status );
        
        try {
            CategoryDAO dao = new CategoryDAO();
            boolean result = dao.updateCartegory(categoryID, name, description, status);
            if (result) {
                url = siteMaps.getProperty(
                        MyApplicationConstants.AdminUpdateCategoryServlet.ADMINCATEGORYLIST_PAGE);
            }
        } catch (SQLException ex) {
            log("AdminUpdateCategoryServlet _ SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
            log("AdminUpdateCategoryServlet _ Naming _ " + ex.getMessage());
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
