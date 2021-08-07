package com.example.BagShop.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/getImage")
public class GetImageServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "/Users/vartan/Documents/java2021/BagShop/src/main/webapp/uploadedImages/ ";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String picUrl = req.getParameter("picUrl");

        String filePath = UPLOAD_DIR + picUrl;
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        resp.setContentType("image/jpeg");
        resp.setContentLength((int) downloadFile.length());
        OutputStream outStream = resp.getOutputStream();
        byte[] buffer = new byte[4896];
        int bytesRead = -1;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inStream.close();
        outStream.close();

    }
}
