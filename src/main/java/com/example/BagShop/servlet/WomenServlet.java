package com.example.BagShop.servlet;

import com.example.BagShop.enums.BagType;
import com.example.BagShop.manager.BagManager;
import com.example.BagShop.model.Bag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/women")
public class WomenServlet extends HttpServlet {
    private BagManager bagManager=new BagManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Bag> bags= bagManager.getBags();
        req.setAttribute("bags", bags);
        req.getRequestDispatcher("/WEB-INF/women.jsp").forward(req, resp);

    }
}
