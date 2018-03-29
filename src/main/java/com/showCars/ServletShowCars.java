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
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<Car> cars = new ArrayList();
        try {
            cars = Dao.getDAO().getCars();
            System.out.println(cars);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < cars.size() ; i++) {
            out.println(String.valueOf(cars.get(i)));
        }
        out.flush();
        out.close();

    }

}