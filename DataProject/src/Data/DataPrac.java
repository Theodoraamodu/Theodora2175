package Data;

import java.sql.*;

public class DataPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn= null;
		Statement stat=null;
		ResultSet rs = null;
		
		try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("problem in loading the driver");
			ex.printStackTrace();
		}
		
		try {
			String dbName = "Employeee.accdb";
			String dbURL="jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			
			/*String query = "INSERT INTO EMP (EName, Salary)" + " values ('ABC', 95000)";
			stat.executeUpdate(query);*/
			
			rs = stat.executeQuery("SELECT * FROM Employee");
			
//			String query ;
//			query = "UPDATE EMP SET SALARY = 12000 Where EName = 'ABC'";
//			stat.executeUpdate(query);
//			
//			query = "delete from Emp where EName = 'Kim' ";
//			stat.executeUpdate(query);
//			
			
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("id" + id + "Ename" + name + "sal" + sal);
			}
					
		}
		catch(SQLException ex)
		{
			System.out.println("problem with database");
		}
		finally {
			try {
			if (conn!= null) {
			rs.close();
			stat.close();
			conn.close();
			}
		}
	
		catch(SQLException ex)
			{
			ex.printStackTrace();
			}

		}
	}
}
