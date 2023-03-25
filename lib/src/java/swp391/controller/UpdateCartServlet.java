/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp391.cart.CartDAO;
import swp391.cart.CartObject;
import swp391.customer.CustomerDTO;

/**
 *
 * @author nguye
 */
@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/UpdateCartServlet"})
public class UpdateCartServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        CartObject cartItems = (CartObject) session.getAttribute("CART");
        CustomerDTO cusDTO = (CustomerDTO) session.getAttribute("USER");
        String itemId = request.getParameter("txtID");
        int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        cartItems.getItems().put(itemId, quantity);
        try {
            CartDAO dao = new CartDAO();
            if (cusDTO != null) {
                if (dao.checkProduct(cusDTO.getCustomerID(), Integer.parseInt(itemId))) {
                    dao.updateCart(cusDTO.getCustomerID(), Integer.parseInt(itemId), quantity);
                }
            }
        } catch (NamingException ex) {
            log("UpdateCartServlet _ Naming _ " + ex.getMessage());
        } catch (NumberFormatException ex) {
            log("UpdateCartServlet _ NumberFormat _ " + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateCartServlet _ SQL _ " + ex.getMessage());
        } finally {
// Update session attribute
            session.setAttribute("CART", cartItems);
            System.out.println(cartItems.getItems().get(itemId));
            // Send response with success message
            response.setContentType("text/plain");
            response.getWriter().write("Item quantity updated successfully");
        }

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
