package com.example.BagShop.servlet;

import com.example.BagShop.manager.BagManager;
import com.example.BagShop.model.Bag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteBag")
public class DeleteBagServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "/Users/vartan/Documents/java2021/BagShop/src/main/webapp/uploadedImages/ ";
    private BagManager bagManager = new BagManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bagId = Integer.parseInt(req.getParameter("id"));
        bagManager.removeBagById(bagId);
        req.getSession().setAttribute("msg", "Book was removed");
        resp.sendRedirect("/managerHome");
    }

}
