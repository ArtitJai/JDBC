package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataObject {
public static void main(String[] args) throws SQLException {
	

	String url = "jdbc:oracle:thin:@44.203.161.140:1521:XE";
	String userName = "hr";
	String password = "hr";
		
	// Create Connection
	
	Connection conn = DriverManager.getConnection(url, userName, password);
	
	// Create statement
	Statement stmn = conn.createStatement();
	// Execute Query // Get ResultSet
	
	ResultSet rs = stmn.executeQuery("Select * from departments");
	
//	while(rs.next()) {
//		System.out.println(rs.getString(0));
//		System.out.print(rs.getString(1) + "\t");
//		System.out.print(rs.getString(2) + "\t");
//		System.out.print(rs.getString(3) + "\t");
//		System.out.print(rs.getString(4) + "\t");
//		System.out.print(rs.getString(5) + "\t");
//		
//		System.out.println();
//	}
	
	ResultSetMetaData md = rs.getMetaData();
	
//	System.out.println(md.getColumnCount());
	
	for(int i = 1; i <= md.getColumnCount(); i++) {
		System.out.print(md.getColumnName(i) + "\t");
	}
	System.out.println();
	
	while(rs.next()) {
		for(int i = 1; i <= md.getColumnCount(); i++) {
			System.out.print(rs.getString(i) + "\t");
		}
		System.out.println();
	}
	
	
	
	rs.close();
	stmn.close();
	conn.close();
		
}
}
