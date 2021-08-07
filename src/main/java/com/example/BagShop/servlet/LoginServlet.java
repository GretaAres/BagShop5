package com.example.BagShop.servlet;

import com.example.BagShop.enums.UserType;
import com.example.BagShop.manager.UserManager;
import com.example.BagShop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getUsersByEmailAndPassword(email, password);
        if (user == null) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if (user.getUserType() == UserType.MANAGER) {
                resp.sendRedirect("/managerHome");
            } else {
                resp.sendRedirect("/home");
            }

        }
    }
}
