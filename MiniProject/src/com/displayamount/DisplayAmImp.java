package com.displayamount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAmImp implements DisplyAm {

    @Override
    public void amount() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        double totalAmount = 0.0;

        try {
            // Step-1: Loading driver class
            Class.forName("com.mysql.jdbc.Driver");

            // Step-2: Establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

            // Step-3: Use prepared statement
            String query = "select price from cart";
            ps = con.prepareStatement(query);

            // Step-4: ResultSet
            rs = ps.executeQuery();

            while (rs.next()) {
                double price = rs.getDouble("price");
                totalAmount += price;
            }

            System.out.println("Display the amount to End User: " + totalAmount);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
                rs.close();
                ps.close();
                con.close();
        }
        }
        

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DisplayAmImp ds = new DisplayAmImp();
        ds.amount();
    }
}
