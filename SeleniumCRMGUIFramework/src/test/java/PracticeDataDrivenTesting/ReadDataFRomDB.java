package PracticeDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ReadDataFRomDB {
	@Test
	public void executeselectquery() throws SQLException {
		//step1: load the database
	Connection conn = null;
	try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	//step2: connect to database
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
    System.out.println("-----done----");
    //step3: create statement
    Statement sta = conn.createStatement();
    //step4: execute query
    ResultSet result = sta.executeQuery("select * from student");
    while(result.next()) {
    	System.out.println(result.getString(1)+"\t"+result.getString(2));
    }
	}
	catch(Exception e) {
		System.out.println("handle any exception");
	}
	finally{
    //step5 : close the connection
    conn.close();
	}
     
}
	@Test
	public void executenonselectquery() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//step2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
	    //System.out.println("-----done----");
	    //step3: create statement
	    Statement sta = conn.createStatement();
	    //step4: execute update query
	    int result = sta.executeUpdate(" insert into student values(106,'ooo','1789652156','maven');");
	    System.out.println(result);
	    conn.close();
	}
}
