package com.showCars.dao;

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

    public String getCars() throws URISyntaxException, SQLException {
        Connection con = DBConnection.getConnection();
        if (con != null) System.out.println("connection good");
        PreparedStatement ps = createPreparedStatement(con);
        ResultSet rs = ps.executeQuery();
        String cars = "cars: ";
        while (rs.next()) {
            String s = rs.getString("model");
            System.out.println(s);
            cars.concat(s);
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

//    public List getAll() {
//        List<Car> cars = new ArrayList();
//        String sql = "SELECT * FROM car";
//                try (Connection connection = DBConnection.getConnection()) {
//
//            try (
//                    Statement statement = connection.createStatement()
//            ) {
//                ResultSet rs = statement.executeQuery(sql);
//                while (rs.next()) {
//                    Car car = new Car();
//
//                    car.setModel(rs.getString("model"));
//
//                    car.setColor(rs.getString("color"));
//
//                    cars.add(car);
//                }
//            }} catch (URISyntaxException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return cars;
//        }
//
//        @Override
//        public void save (Object o){


//    public void save(Car car) {
//        String sql = String.format(
//                "insert INTO car(model, color) values('%s', '%s');",
//                car.getModel(), car.getColor()
//        );
//        try (Connection connection = DBConnection.getConnection();
//             Statement statement = connection.createStatement()
//        ) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            System.out.println("Error" + e);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//
//    }

