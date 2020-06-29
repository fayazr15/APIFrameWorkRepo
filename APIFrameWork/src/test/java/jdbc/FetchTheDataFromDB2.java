package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.api.genericlib.BaseClass;
import com.mysql.jdbc.Driver;

public class FetchTheDataFromDB2 extends BaseClass

{
	@Test
	public void checkDataFromDB1() throws IOException, SQLException
	{
		Driver d = new Driver();
		
		DriverManager.registerDriver(d);
		
		String conData = config.getApiTestData("sqlConnection");
		
		String[] splitconData = conData.split(";");
		
		Connection con = DriverManager.getConnection(splitconData[0],splitconData[1],splitconData[2]);
		
		Statement stat = con.createStatement();
		
		String query ="select * from coronadata order by patientNO desc;";
		
		ResultSet rs = stat.executeQuery(query);
		
		System.out.println("===========================================");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		System.out.println("===========================================");
		
		con.close();
		
		
	}
	
	@Test
	public void checkDataFromDB2() throws IOException, SQLException
	{
		Driver d = new Driver();
		
		DriverManager.registerDriver(d);
		
		String conData = config.getApiTestData("sqlConnection");
		
		String[] splitconData = conData.split(";");
		
		Connection con = DriverManager.getConnection(splitconData[0],splitconData[1],splitconData[2]);
		
		Statement stat = con.createStatement();
		
		String query ="select patientNO from coronadata;";
		
		ResultSet rs = stat.executeQuery(query);
		
		System.out.println("===========================================");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		System.out.println("===========================================");
		
		con.close();
	}
}
