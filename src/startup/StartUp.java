package startup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StartUp {

	public static void main(String[] args) {
		
		// Creates a database connection which only lasts as long as this try statement is active
		// Afterwards, the connection is closed
        try (
          Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
          Statement statement = connection.createStatement();
        )
        {
          statement.setQueryTimeout(30);  // If a query isn't answered in 30 Seconds: Throws an error
          
          statement.executeUpdate("drop table if exists Account"); // This is dumb, and should NOT be in the real code later on
          statement.executeUpdate("CREATE TABLE Account ("
          		+ "id INTEGER PRIMARY KEY,"
          		+ " name STRING)"); 
          statement.executeUpdate("insert into Account values(1, 'Tralalero')");
          statement.executeUpdate("insert into Account values(2, 'Ambalabu')");
          
          ResultSet rs = statement.executeQuery("SELECT * "
          		+ "FROM Account "); // rs yields all the rows obtained by this query
          
          while(rs.next()) { //prints out everything that rs yields
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
          }
        }
        
        catch(SQLException e) {
          e.printStackTrace(System.err);
        }
      }
    
}


