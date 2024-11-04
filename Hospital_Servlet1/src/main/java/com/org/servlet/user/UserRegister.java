package com.org.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age")); // Get age from request
        String gender = req.getParameter("gender"); // Get gender from request
        String phoneNumber = req.getParameter("phno"); // Get phone number from request

        User u = new User(fullname, email, password, age, gender, phoneNumber); // Pass all fields
        UserDao dao = new UserDao();
        
        String[] errorMsg = new String[1]; // Array to hold error messages
        boolean res = dao.registerUser(u, errorMsg); // Pass the user and error message array
        
        HttpSession hs = req.getSession();
        
        if(res) {
            hs.setAttribute("sucMsg", "SIGNUP SUCCESS");
            resp.sendRedirect("signup.jsp");
        } else {
            hs.setAttribute("errorMsg", errorMsg[0]); // Set specific error message
            resp.sendRedirect("signup.jsp");
        }
    }

}
