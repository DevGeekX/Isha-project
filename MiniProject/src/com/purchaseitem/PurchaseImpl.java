package com.purchaseitem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PurchaseImpl implements Purchase {

	@Override
	public void Shoppingcart() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product id to buy product>>");
        int productId = scanner.nextInt();
        System.out.print("Enter the quantity>>");
        int quantity = scanner.nextInt();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Step-1: Loading driver class
            Class.forName("com.mysql.jdbc.Driver");

            // Step-2: Establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

            // Step-3: Use prepared statement to insert product into cart
            String insertQuery = "INSERT INTO cart (productid, productquantity) VALUES (?, ?)";
            ps = con.prepareStatement(insertQuery);
            ps.setInt(1, productId);
            ps.setInt(2, quantity);
            ps.executeUpdate();

            // Indicate that the product has been added to the cart
            System.out.println("Product item has been added to cart.");

            // Step-4: Retrieve and display username and total bill amount
            System.out.print("Enter your username>> ");
            String username = scanner.next();

            String selectQuery = "SELECT username, SUM(productquantity * productprice) AS totalBillAmount " +
                                 "FROM cart JOIN products ON cart.productid = products.productid " +
                                 "WHERE username = ? GROUP BY username";
            ps = con.prepareStatement(selectQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Total Bill Amount: " + rs.getDouble("totalBillAmount"));
            } else {
                System.out.println("No records found for the given username.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PurchaseImpl buyProduct = new PurchaseImpl();
        buyProduct.Shoppingcart();
    }
	}

