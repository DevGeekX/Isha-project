package com.guest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.checkregistereduser.UserHistoryImpl;

public class ViewProductImpl implements ViewProduct {
	private int productId;

	@Override
	public void productInput() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the product id>> ");
			productId = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter valid data.");
		} finally {
			sc.close();
		}

	}

	@Override
	public void ProductCheck() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			// Step-1- Loading driver class
			Class.forName("com.mysql.jdbc.Driver");
			// Step-2- Establish connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			// Step-3: Use prepared statement
			String query = "SELECT * FROM product WHERE productid = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, productId);
			// Step-4- use ResultSet
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // next()return true
				System.out.println("Product id>> " + rs.getInt("productid"));
				System.out.println("Product Description>> " + rs.getString("productdescription"));
				System.out.println("Amount>> " + rs.getString("price"));
				System.out.println("Quantity>> " + rs.getString("productquantity"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		} finally {
			ps.close();
			con.close();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ViewProductImpl viewHistory = new ViewProductImpl();
		viewHistory.productInput();
		viewHistory.ProductCheck();
	}

}
