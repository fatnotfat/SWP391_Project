/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp391.customer.CustomerCreateError;
import swp391.customer.CustomerDAO;
import swp391.customer.CustomerDTO;
import swp391.customer.CustomerForgotPassword;
import swp391.utils.MyApplicationConstants;
import swp391.utils.SendEmail;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

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
                MyApplicationConstants.CreateAccountServlet.ERROR_PAGE);
        String firstName = request.getParameter("txtFirstName");
        byte[] bytes1 = firstName.getBytes(StandardCharsets.ISO_8859_1);
        firstName = new String(bytes1, StandardCharsets.UTF_8);

        String lastName = request.getParameter("txtLastName");
        byte[] bytes2 = lastName.getBytes(StandardCharsets.ISO_8859_1);
        lastName = new String(bytes2, StandardCharsets.UTF_8);

        String password = request.getParameter("txtPassword");
        String email = request.getParameter("txtEmail");
        String birthDateTxt = request.getParameter("txtBirthDate");
        String sexTxt = request.getParameter("txtSex");
        String confirm = request.getParameter("txtConfirm");
        boolean errorFound = false;
        CustomerCreateError errors = new CustomerCreateError();
        try {
            //Check all user error
            CustomerDAO dao = new CustomerDAO();
            if (firstName.trim().length() < 1) {
                errorFound = true;
                errors.setFirstNameLengthError("You can't leave this empty");
            }
            if (lastName.trim().length() < 1) {
                errorFound = true;
                errors.setLastNameLengthError("You can't leave this empty");
            }

            if (password.trim().length() < 1) {
                errorFound = true;
                errors.setPasswordLengthError("You can't leave this empty");
            } else if (password.trim().length() < 6 || password.trim().length() > 30) {
                errorFound = true;
                errors.setPasswordLengthError(
                        "Password is required input from 6 to 30 characters");
            } else if (!password.trim().equals(confirm.trim())) {
                errorFound = true;
                errors.setConfirmNotMatched("Confirm must be matched password");
            }
            //validation for email
            String[] parts = email.split("@");
            if (parts.length < 2) {
                errorFound = true;
                errors.setEmailLengthError("Invalid email!");
            } else {
                String[] validDomains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "fpt.edu.vn"};
                boolean flags = false;
                for (String validDomain : validDomains) {
                    if (parts[1].equals(validDomain)) {
                        flags = true;
                        break;
                    }
                }
                if (!flags) {
                    errorFound = true;
                    errors.setEmailLengthError("Invalid domain!!");
                }
            }
            if (email.trim().length() < 1) {
                errorFound = true;
                errors.setEmailLengthError("You can't leave this empty");
            } else if (dao.checkEmail(email)) {
                errorFound = true;
                errors.setEmailIsExisted(email + " is existed!!!");
            }
            if (birthDateTxt.trim().length() < 1) {
                errorFound = true;
                errors.setBirthDateLengthError("You must set your birthday!!!");
            }
            if (errorFound) {
                //catch error
                request.setAttribute("SIGNUP_ERROR", errors);
                //transfer to inform users
            } else {
                //Call DAO to insert DB
//                DateFormat DFormat = new SimpleDateFormat("MM-dd-yyyy");
//                Date birthDate = DFormat.parse(birthDateTxt);
                Date birthDate = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(birthDateTxt);
                boolean sex = false;
                if (sexTxt.equals("Male")) {
                    sex = true;
                }         
//                boolean result = dao.createAccount(dto);
//                if (result) {
                    SendEmail sm = new SendEmail();
                    //get the 6-digit code
                    String code = sm.getRandom();
                    //craete new user using all information
                    CustomerForgotPassword customer = new CustomerForgotPassword(email, code);
                    //call the send email method
                    boolean test = sm.sendEmail(customer);
                    //check if the email send successfully
                    if (test) {
                        CustomerDTO dto
                        = new CustomerDTO(firstName + " " + lastName, password, birthDate, email,
                                "none", "none", false, 1, sex, 0);
                        HttpSession session = request.getSession();
                        session.setAttribute("authcode", customer);
                        session.setAttribute("email", email);
                        session.setAttribute("CREATE_ACCOUNT", dto);
                        url = siteMaps.getProperty(
                                MyApplicationConstants.CustomerVerifyServlet.VERIFYCODE_PAGE);
                    } else {
                        request.setAttribute("VERIFYMAIL_SCOPE", "Failed to send verification email");
                    }
//                }
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("SignUp _ SQL _ " + msg);
        } catch (NamingException ex) {
            log("SignUp _ Naming _ " + ex.getMessage());
        } catch (ParseException ex) {
            log("DateFormat _ Parse _" + ex.getMessage());
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
