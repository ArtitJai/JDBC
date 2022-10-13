package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scrollable_ResultSet {
	
public static void main(String[] args){
		
		/*
		 * 5 steps framework for JDBC:
		 * 
		 * 1. Create Connection
		 * 2. Create Statement
		 * 3. Execute Query
		 * 4. Get REsultSet
		 * 5.Close Connection
		 * 
		 */
		
//		 * 1. Create Connection
		String url = "jdbc:oracle:thin:@44.203.161.140:1521:XE";
		String userName = "hr";
		String password = "hr";
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		 
		
		
//	     * 2. Create Statement
		Statement stmn = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//		 * 3. Execute Query
		
//		 * 4. Get REsultSet
		ResultSet rs = stmn.executeQuery("SELECT * FROM departments");

		
		rs.relative(5);
//		while(rs.next()) {
			System.out.print(rs.getString("DEPARTMENT_ID") + "\t");
			System.out.print(rs.getString("DEPARTMENT_NAME") + "\t");
			System.out.print(rs.getString("MANAGER_ID") + "\t");
			System.out.print(rs.getString("LOCATION_ID") + "\t");
			
			System.out.println();
		
		rs.previous();
		
			System.out.print(rs.getString("DEPARTMENT_ID") + "\t");
			System.out.print(rs.getString("DEPARTMENT_NAME") + "\t");
			System.out.print(rs.getString("MANAGER_ID") + "\t");
			System.out.print(rs.getString("LOCATION_ID") + "\t");
			
			System.out.println();

		rs.absolute(27);
			
			System.out.print(rs.getString("DEPARTMENT_ID") + "\t");
			System.out.print(rs.getString("DEPARTMENT_NAME") + "\t");
			System.out.print(rs.getString("MANAGER_ID") + "\t");
			System.out.print(rs.getString("LOCATION_ID") + "\t");
		
			System.out.println();
//		}
//		
		
//		 * 5.Close Connection
		
		rs.close();
		stmn.close();
		conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

