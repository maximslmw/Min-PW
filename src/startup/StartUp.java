package startup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StartUp {

	//TODO: Change StartUp to get all Accounts from DB and save them in Map of AccountManager
	public static void main(String[] args) {
        try (
          Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
          Statement statement = connection.createStatement();
        )
        {
          statement.setQueryTimeout(30);  // If a query isn't answered in 30 Seconds: Throws an error
          
          statement.executeUpdate("drop table if exists Accounts"); // This is dumb, and should NOT be in the real code later on
          statement.executeUpdate("drop table if exists Account");
          statement.executeUpdate("CREATE TABLE Accounts ("
          		+ "id STRING PRIMARY KEY,"
          		+ "plattform STRING NOT NULL,"
          		+ "name STRING,"
          		+ "email STRING NOT NULL,"
          		+ "password STRING NOT NULL,"
          		+ "salt STRING NOT NULL)"); 
          
          // this is a joke
          statement.executeUpdate("insert into Accounts values('1', 'twitter.com', 'noel', 'sbdt@gmail.com', '1234', '1')");
          
          ResultSet rs = statement.executeQuery("SELECT * "
          		+ "FROM Accounts "); // rs yields all the rows obtained by this query
          
          while(rs.next()) { //prints out everything that rs yields
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
            System.out.println("password = " + rs.getInt("password"));
          }
        }
        
        catch(SQLException e) {
          e.printStackTrace(System.err);
        }
      }
    
}


