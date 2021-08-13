package com.example.BagShop.servlet;

import com.example.BagShop.manager.BagManager;
import com.example.BagShop.model.Bag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateBag")
public class UpdateBagServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "/Users/vartan/Documents/java2021/BagShop/src/main/webapp/uploadedImages/ ";
    private BagManager bagManager = new BagManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bagId = Integer.parseInt(req.getParameter("id"));
        Bag bag = bagManager.getBagsById(bagId);
        req.setAttribute("bag", bag);
        req.getRequestDispatcher("/WEB-INF/addBag.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int bagId = Integer.parseInt(req.getParameter("id"));
        Bag bagById = bagManager.getBagsById(bagId);
        if (bagById != null) {

            Part filePart = req.getPart("picture");
            String fileName = filePart.getSubmittedFileName();
            String picUrl = System.currentTimeMillis() + "_" + fileName;
            filePart.write(UPLOAD_DIR + picUrl);

            String name = req.getParameter("name");
            String description=req.getParameter("description");
            int  count = Integer.parseInt(req.getParameter("count"));
            double price = Double.parseDouble(req.getParameter("price"));

            Bag bag = Bag.builder()
                    .id(bagId)
                    .name(name)
                    .description(description)
                    .count(count)
                    .price(price)
                    .picUrl(picUrl)
                    .build();

            bagManager.updateBag(bag);
            req.getSession().setAttribute("msg", "Bag was updated");
            resp.sendRedirect("/addBag");
        }
    }
}
