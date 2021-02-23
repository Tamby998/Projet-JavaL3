package DevoirJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecter {
	Connection con;
	public Connecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etude", "root", "");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	Connection obtenirConnexion() {
		return con;
	}
}
