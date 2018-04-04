package com.showCars.servlet;


import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/showCars"}
)
public class ServletShowCars extends HttpServlet {

    @Autowired
    private IAdDao adDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Ad> ads = adDao.getAll();
        System.out.println(ads);
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello heroku".getBytes());
        out.println(String.valueOf(ads));
        out.flush();
        out.close();
    }


}