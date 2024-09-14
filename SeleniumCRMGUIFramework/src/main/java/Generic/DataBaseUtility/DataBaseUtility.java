package Generic.DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	//this method for get the DB connection
	public void getDBConnection(String url, String username, String pswd) throws SQLException {
		try {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		 con = DriverManager.getConnection(url, username, pswd);
		
		}
		catch(Exception e) {}//if connection is not happening i should able to handle the exception	
		
	}
	
	// this method for get the DB connection with credentials
	public void getDBConnection() throws SQLException {
		try {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		
		}
		catch(Exception e) {}//if connection is not happening i should able to handle the exception	
		
	}
	
	
	//this method for close the DB connection
	public void closeDBconnection() throws SQLException {
		try {
		con.close();
		}catch(Exception e) {}//connection close itself not happen handle the exception-
	}
	//this method for executem select query 
	public ResultSet executeselectquery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement sta = con.createStatement();
		 result = sta.executeQuery(query);
		}
		catch(Exception e) {}
		return result;
	}
	public int executeNonselectquery(String query) throws SQLException {
		int result=0;
		try {
		Statement sta = con.createStatement();
		 result = sta.executeUpdate(query);
		}
		catch(Exception e) {}
		return result;
	}
}
