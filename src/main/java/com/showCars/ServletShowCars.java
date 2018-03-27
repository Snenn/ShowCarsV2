package com.showCars;


import com.showCars.dao.Dao;
import com.showCars.pojos.Car;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        List<Car> cars = Dao.getDAO().getAll();
        out.write("hello heroku".getBytes());
        out.println(cars.toString());
        out.flush();
        out.close();
    }

}