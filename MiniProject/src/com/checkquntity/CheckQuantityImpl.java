package com.checkquntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantityImpl implements CheckQuantity {

    private int productId;

    @Override
    public void userinput() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Product Id>> ");
            productId = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid data.");
        } finally {
            sc.close();
        }
    }

    @Override
    public void jdbc() throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Step-1- Loading driver class
            Class.forName("com.mysql.jdbc.Driver");
            // Step-2- Establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
            // Step-3- use prepared statement
            String query = "SELECT productquantity FROM product WHERE productid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            // Step-4- use ResultSet
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // next()return true
				System.out.println("Quantity is>>" + rs.getInt(1));
				
			}

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             ps.close();
             con.close();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CheckQuantityImpl checkQuantity = new CheckQuantityImpl();
        checkQuantity.userinput();
        checkQuantity.jdbc();
    }
}
