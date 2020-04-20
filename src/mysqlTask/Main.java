package mysqlTask;

import java.sql.*;

public class Main {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";
	
	 public static void main(String[] args) {
		
		 // establish connection
		 dbHandler gamedb = new dbHandler(JDBC_DRIVER, DB_URL,USER,PASS);
		 
		 
		//create record
		gamedb.Create("Customers", 2, "john", "johnsmith@gmail.com", "123 high road");
		gamedb.Create("Customers", 3, "Andy", "Andy@gmail.com", "27 back road"); 
		 
		 //update record
		 gamedb.Update("Customers", 2, "john","johnsmith@gmail.com" , "456 high road");
		 
		 
		 //Read
		 gamedb.Read("Customers");
		 
		 
		 //Delete
		 gamedb.Delete("Customers", 2);
		 
	}
	 
}
