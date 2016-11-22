package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/youcook?useUnicode=true&characterEncoding=UTF-8&useSSL=false";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "****";



	public static Connection open() throws SQLException {

			// STEP 2: Register JDBC driver
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				throw new SQLException("MySQL Driver error: " + e.getMessage());

			}

			return DriverManager.getConnection(DB_URL, USER, PASS);

		}

	}




