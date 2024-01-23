package exercise_PostgresConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DciDBConnector {
	
	private String url;
	private String username;
	private String password;
	
	public DciDBConnector(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		
	}
	
	public void listTables() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//Class.forName("org.postgresql.Driver");
			
			myConn = DriverManager.getConnection(url, username, password);
			
			myStmt = myConn.createStatement();
			
			String showTables = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';";
			
			myRs = myStmt.executeQuery(showTables);
			
			while(myRs.next()) {
				System.out.println("Table name: " + myRs.getString("table_name"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(myConn != null) {
				myConn.close();
			}
		}
	}

}
