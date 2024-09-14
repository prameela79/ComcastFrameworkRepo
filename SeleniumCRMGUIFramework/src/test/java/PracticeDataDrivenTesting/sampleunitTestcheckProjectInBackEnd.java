package PracticeDataDrivenTesting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class sampleunitTestcheckProjectInBackEnd {

	@Test
	public void studentchecktestcase() throws SQLException {
		 String expectedsname = "abc";
		 boolean flag = false;
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery("select * from student");
		while(result.next()) {
			String sname = result.getString(2);
			if(expectedsname.equals(sname)) {
				flag=true;
				System.out.println("yes available");
			}

		}
		if(flag==false) {
			System.out.println("not available");
		}
		conn.close();
	}
}
