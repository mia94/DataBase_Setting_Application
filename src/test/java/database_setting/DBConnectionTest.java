package database_setting;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import database_setting.jdbc.ConnectionProvider;
import database_setting.jdbc.LogUtil;


public class DBConnectionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start Connection Test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End Connection Test");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test() {
		try(Connection connection = ConnectionProvider.getConnection("db.properties")){
			LogUtil.prnLog(connection.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}





