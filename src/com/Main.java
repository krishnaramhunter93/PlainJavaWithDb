package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hellodb", "root", "root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				con.close();
			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
