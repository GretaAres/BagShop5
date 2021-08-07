package com.example.BagShop.servlet;

import com.example.BagShop.manager.BagManager;
import com.example.BagShop.manager.UserManager;
import com.example.BagShop.model.Bag;
import com.example.BagShop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.BitSet;
import java.util.List;

@WebServlet(urlPatterns = "/managerHome")
public class ManagerHomeServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    private BagManager bagManager = new BagManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Bag> allBags = bagManager.getBags();
        List<User> allUsers = userManager.getAllUsers();
        req.setAttribute("bags", allBags);
        req.setAttribute("users", allUsers);
        req.getRequestDispatcher("/WEB-INF/manager.jsp").forward(req, resp);

    }
}
