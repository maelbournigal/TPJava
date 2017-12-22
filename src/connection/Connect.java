package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	public static Connection con = null;
	
	public static void Connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		}
		catch(ClassNotFoundException e) {
			System.out.println("Impossible de charger le pilote ");
		};
		
		try {
			String DBurl = "jdbc:mysql://localhost:3306/villes_france";
			con = DriverManager.getConnection(DBurl, "mael", "09042016");
		}
		catch(SQLException e) {
			System.out.println("Connection à  la base de données impossible");
		};
		
	}
	public static void Close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Probleme de fermeture de la base de donnes");
		}
	}
}
