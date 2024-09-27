package com.buyproduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyProductImpl implements BuyProduct {
    @Override
    public void Shoppingcart() throws SQLException, ClassNotFoundException {
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

            // Step-3: Fetch product details from product table
            String fetchProductQuery = "SELECT productname, price, productquantity FROM product WHERE productid = ?";
            ps = con.prepareStatement(fetchProductQuery);
            ps.setInt(1, productId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String productName = rs.getString("productname");
                String price = rs.getString("price");
                int availableQuantity = rs.getInt("productquantity");

                // Check if requested quantity is available
                if (quantity > availableQuantity) {
                	// CHANGE THIS EXCEPTION TO CUSTOM EXCEPTION
                    throw new StringIndexOutOfBoundsException("Requested quantity exceeds available stock.");
                }

                // Step-4: Insert product details into cart table
                String insertCartQuery = "INSERT INTO cart (productid, productname, productquantity, price) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertPs = con.prepareStatement(insertCartQuery)) {
                    insertPs.setInt(1, productId);
                    insertPs.setString(2, productName);
                    insertPs.setInt(3, quantity);
                    insertPs.setString(4, price);
                    insertPs.executeUpdate();
                }

            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Do you want to view cart (Yes/No)>>");
            String viewCart = scanner.next();

            if (viewCart.equalsIgnoreCase("Yes")) {
                String selectCartSQL = "select * from cart";
                try (PreparedStatement pst = con.prepareStatement(selectCartSQL);
                     ResultSet rst = pst.executeQuery()) {
                    while (rst.next()) {
                        System.out.println("Cart ID: " + rst.getInt("cartid") +
                                           ", Product ID: " + rst.getInt("productid") +
                                           ", Product Name: " + rst.getString("productname") +
                                           ", Quantity: " + rst.getInt("productquantity") +
                                           ", Price: " + rst.getString("price"));
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
           
                rs.close();
                 ps.close();
                 con.close();
                scanner.close();
            } 
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BuyProductImpl buyProduct = new BuyProductImpl();
        buyProduct.Shoppingcart();
    }
}
