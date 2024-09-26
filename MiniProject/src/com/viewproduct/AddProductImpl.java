package com.viewproduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.buyproduct.BuyProductImpl;

public class AddProductImpl implements AddProduct{

	@Override
	public void add() {
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

            // Step-3: Use prepared statement
            String query = "INSERT INTO cart (productid, productquantity) VALUES (?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, quantity);
            ps.executeUpdate();
            
            System.out.println("Product item has been added to cart.");
           
            String viewCart = scanner.next();

            if (viewCart.equalsIgnoreCase("Yes")) {
                String selectCartSQL = "SELECT * FROM cart";
                try (PreparedStatement pst = con.prepareStatement(selectCartSQL);
                     ResultSet rst = pst.executeQuery()) {
                    while (rst.next()) {
                        System.out.println("Product ID: " + rst.getInt("productid") + ", Quantity: " + rst.getInt("productquantity"));
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                 ps.close();
                con.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	 public static void main(String[] args) {
	        AddProductImpl AddProduct = new AddProductImpl();
	        AddProduct.add();
	    }
	}


