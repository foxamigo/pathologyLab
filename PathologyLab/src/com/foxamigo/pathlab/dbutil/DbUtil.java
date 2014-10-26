package com.foxamigo.pathlab.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection conn;
	public DbUtil() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");//Connection establishment to the database
		String username = "root";
		String password = "root";
		String Database = "jdbc:mysql://localhost:3306/pathlab";


		conn = DriverManager.getConnection( Database, username, password );
		System.out.println("*** Connect to the database ***");
	}
	public static Connection getConnection()
	{
		return conn;
	}
}
