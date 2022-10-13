package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JBDC_Intro {
	public static void main(String[] args) throws SQLException{
		
		/*
		 * 5 steps framework for JDBC:
		 * 
		 * 1. Create Connection
		 * 2. Create Statement
		 * 3. Execute Query
		 * 4. Get REsultSet
		 * 5.Close Connection
		 * 
		 * 
		 */
		
//		 * 1. Create Connection
		String url = "jdbc:oracle:thin:@44.203.161.140:1521:XE";
		String userName = "hr";
		String password = "hr";
		
		Connection conn = DriverManager.getConnection(url, userName, password);
		
		
//	     * 2. Create Statement
		Statement stmn = conn.createStatement();
//		 * 3. Execute Query
		
//		 * 4. Get REsultSet
		ResultSet rs = stmn.executeQuery("SELECT * FROM departments");
//		
//		rs.next();
//		rs.next();
//		
//		System.out.println(rs.getString("DEPARTMENT_ID"));
//		System.out.println(rs.getString("DEPARTMENT_NAME"));
//		System.out.println(rs.getString("MANAGER_ID"));
//		System.out.println(rs.getString("LOCATION_ID"));
		
		while(rs.next()) {
			System.out.print(rs.getString("DEPARTMENT_ID") + "\t");
			System.out.print(rs.getString("DEPARTMENT_NAME") + "\t");
			System.out.print(rs.getString("MANAGER_ID") + "\t");
			System.out.print(rs.getString("LOCATION_ID") + "\t");
			
			System.out.println();
		}
		
		
//		 * 5.Close Connection
		
		rs.close();
		stmn.close();
		conn.close();
	}
}
