package com.showCars.dao;

import com.showCars.pojos.Car;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Dao implements IDao {

    private static Dao dao;

    public static Dao getDAO() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }

    public List<Car> getCars() throws URISyntaxException, SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = createPreparedStatement(con);
        ResultSet rs = ps.executeQuery();
        List<Car> cars = Collections.EMPTY_LIST;
        while (rs.next()) {
            Car car = new Car();
            car.setId(rs.getInt("id"));
            car.setModel(rs.getString("model"));
            car.setColor(rs.getString("color"));
            System.out.println(car+ "   cars:  "+cars);
            cars.add(car);
        }
        return cars;
    }


    private PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        String sql = "SELECT * FROM car";
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }
}


