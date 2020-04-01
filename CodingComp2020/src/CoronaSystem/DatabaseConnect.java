package CoronaSystem;
import java.sql.*;
import javax.swing.JOptionPane;
public class DatabaseConnect {
	Connection conn=null;
	
	public static Connection getConnection() {
		String username="root";
		String password="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/CoronaSystem",username,password);
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Database Conncetion Problem.");
		}
		return null;
	}
}
