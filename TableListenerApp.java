package exercise_PostgresConnection;

import java.sql.SQLException;

public class TableListenerApp {

	public static void main(String[] args) throws SQLException {
	
		String url = "jdbc:postgresql://localhost:5432/test";
		String username = "postgres";
		String password = "SuperMaria20";
		
		DciDBConnector connector = new DciDBConnector(url, username, password);
		
		connector.listTables();

	}

}
