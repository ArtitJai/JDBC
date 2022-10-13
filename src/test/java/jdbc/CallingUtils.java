package jdbc;

import java.util.List;
import java.util.Map;

public class CallingUtils {

	public static void main(String[] args) {
		
		JDBC_Util.createConnection();
		JDBC_Util.runQuery("select * from employees");
		JDBC_Util.displayAllData();
		
		JDBC_Util.runQuery("Select * from Departments");
		JDBC_Util.displayAllData();
		
		List<String>departments = JDBC_Util.getColumnDataAsList("DEPARTMENT_NAME");
		
		System.out.println(departments);
		
		List<String>rowNumber5 = JDBC_Util.getRowDataAsList(5);
		
		System.out.println(rowNumber5);
		
		JDBC_Util.runQuery("select * from job_history");
		
		Map<String, String> row8 = JDBC_Util.getRowMap(8);
		
		System.out.println(row8.get("EMPLOYEE_ID"));
		System.out.println(row8.get("START_DATE"));
		System.out.println(row8.get("END_DATE"));
		System.out.println(row8.get("DEPARTMENT_ID"));

	}

}
