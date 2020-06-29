package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;





public class FetchTheDataFromDBTest 

{

	
	public static void main(String[] args) throws SQLException
	{
		Driver d = new Driver();
		
		DriverManager.registerDriver(d);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/corona_patient_info", "j2ee", "5544");
		
		Statement stat = con.createStatement();
		
		String query ="select * from coronadata;";
		ResultSet rs = stat.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		con.close();
		
		
	}
}
