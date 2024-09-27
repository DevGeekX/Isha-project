package com.viewproduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProductImpl implements AddProduct {

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

			// Step-3: Fetch product details from product table
			String fetchProductQuery = "SELECT productname, price FROM product WHERE productid = ?";
			ps = con.prepareStatement(fetchProductQuery);
			ps.setInt(1, productId);
			rs = ps.executeQuery();

			if (rs.next()) {
				String productName = rs.getString("productname");
				String price = rs.getString("price");

				// Step-4: Insert product details into cart table
				String insertCartQuery = "INSERT INTO cart (productid, productname, productquantity, price) VALUES (?, ?, ?, ?)";
				try (PreparedStatement insertPs = con.prepareStatement(insertCartQuery)) {
					insertPs.setInt(1, productId);
					insertPs.setString(2, productName);
					insertPs.setInt(3, quantity);
					insertPs.setString(4, price);
					insertPs.executeUpdate();
				}

				System.out.println("5.Product item has been added to cart.");
			} else {
				System.out.println("Product not found.");
			}

			String viewCart = scanner.next();

			if (viewCart.equalsIgnoreCase("Yes")) {
				String selectCartSQL = "SELECT * FROM cart";
				try (PreparedStatement pst = con.prepareStatement(selectCartSQL); ResultSet rst = pst.executeQuery()) {
					while (rst.next()) {
						System.out.println("Product ID: " + rst.getInt("productid") + ", Product Name: "
								+ rst.getString("productname") + ", Quantity: " + rst.getInt("productquantity")
								+ ", Price: " + rst.getString("price"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		AddProductImpl addProduct = new AddProductImpl();
		addProduct.add();
	}
}
