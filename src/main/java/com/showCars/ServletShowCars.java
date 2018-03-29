package com.showCars;


import com.showCars.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/showCars"}
)
public class ServletShowCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        String cars = new String();
        try {
            cars = Dao.getDAO().getCars();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.write("hello heroku".getBytes());
        out.println(String.valueOf(cars));
        out.flush();
        out.close();

    }

}