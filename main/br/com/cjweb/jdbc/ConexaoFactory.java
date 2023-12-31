package br.com.cjweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	
	
	public static Connection getConnection() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/importsweb", "postgres", "postgresql" );
		} catch (SQLException e) {
			
			//relançando exception
			throw new  RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new  RuntimeException(e);
		}
		
		
	}
}
