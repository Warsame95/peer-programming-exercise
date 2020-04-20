package mysqlTask;

import java.sql.*;


public class dbHandler {
	private Connection conn = null;
	private Statement stmt = null;
	
	public dbHandler(String JDBC_DRIVER, String DB_URL, String User, String Pass ) {
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
			
		System.out.println("Starting connection to db");
		
		try {
			this.conn = DriverManager.getConnection(DB_URL,User,Pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("CONNECTION ESTABLISHED");
		
		try {
			this.stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void Create(String tableName, int id, String name, String email, String address) {
		
		String sqlInsert = "Insert into "+ tableName +" values('"+id+"','"+ name+ "','"+ email+ "','"+ address+"')";
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Statement updated");
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void Read(String tableName) {
		
		String sql2 = "SELECT * from "+tableName;
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				int id1 = rs.getInt("customer_id");
				String name1 = rs.getString("name");
				String email1 = rs.getString("email");
				String address1 = rs.getString("address");
				System.out.println("id: "+id1+ " name: "+name1+" email "+ email1+ " Address "+address1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Update(String tableName, int id, String name, String email, String address) {
		
		String sql = "UPDATE " +tableName+ " SET name = '" + name + "', email ='" + email + "', address= '" + address + "' where customer_id = " +id;
		
		try {
			stmt.executeUpdate(sql);
			System.out.println("Update complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void Delete(String tableName, int id) {
		String sql = "DELETE FROM "+tableName+ " where customer_id= "+id;
		try {
			stmt.executeUpdate(sql);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
