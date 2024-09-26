package com.buyproduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyProductImpl implements BuyProduct {
    @Override
    public void Shoppingcart() throws SQLException {
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

            System.out.print("Do you want to view cart (Yes/No)>>");
            String viewCart = scanner.next();

            if (viewCart.equalsIgnoreCase("Yes")) {
                String selectCartSQL = "SELECT * FROM cart";
                PreparedStatement pst = con.prepareStatement(selectCartSQL);
                     ResultSet rst = pst.executeQuery();
                     
                    while (rst.next()) {
                        System.out.println("Product ID: " + rst.getInt("productid") + ", Quantity: " + rst.getInt("productquantity"));
                    
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
           
                 rs.close();
                ps.close();
                con.close();
                scanner.close();
            
        }
    }

    public static void main(String[] args)throws SQLException {
        BuyProductImpl buyProduct = new BuyProductImpl();
        buyProduct.Shoppingcart();
    }
}