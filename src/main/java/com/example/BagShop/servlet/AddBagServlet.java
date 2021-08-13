package com.example.BagShop.servlet;

import com.example.BagShop.enums.BagType;
import com.example.BagShop.manager.BagManager;
import com.example.BagShop.model.Bag;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


@WebServlet(urlPatterns = "/addBag")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddBagServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "/Users/vartan/Documents/java2021/BagShop/src/main/webapp/uploadedImages/ ";
  private   BagManager bagManager = new BagManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addBag.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part filePart = req.getPart("picture");
        String fileName = filePart.getSubmittedFileName();
        String picUrl = System.currentTimeMillis() + "_" + fileName;
        filePart.write(UPLOAD_DIR + picUrl);

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int count = Integer.parseInt(req.getParameter("count"));
        BagType type = BagType.valueOf(req.getParameter("type"));

        Bag bag =Bag.builder()
                .name(name)
                .description(description)
                .price(price)
                .count(count)
                .picUrl(picUrl)
                .type(type)
                .build();

        if (bag != null && bag.getType() == BagType.WOMEN) {
                req.getRequestDispatcher("/WEB-INF/women.jsp");
            }
           else if (bag != null &&  bag.getType() == BagType.MEN) {
                 req.getRequestDispatcher("/WEB-INF/men.jsp");
             }
            else if (bag != null &&  bag.getType() == BagType.CHILD) {
                 req.getRequestDispatcher("/WEB-INF/child.jsp");
             }
            else if (bag != null &&  bag.getType() == BagType.NEW) {
                 req.getRequestDispatcher("/WEB-INF/new.jsp");
             }



        bagManager.addBag(bag);
        req.getSession().setAttribute("msg", "Book was added");
        resp.sendRedirect("/managerHome");

    }


}

