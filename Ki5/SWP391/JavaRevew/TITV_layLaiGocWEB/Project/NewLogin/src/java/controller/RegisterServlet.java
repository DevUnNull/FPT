/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("confirm_password");
        String status = req.getParameter("status");
        String recipient_name = req.getParameter("recipient_name");
        String phone = req.getParameter("phone");
        String adressDetail = req.getParameter("address_detail");
        String city = req.getParameter("city");
        String postalCode = req.getParameter("pastal_code");
        
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        
    }
    
}
