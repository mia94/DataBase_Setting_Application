package database_setting.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
	//커넥션을 제공해주는 역할
	public static Connection getConnection(String propPath) throws SQLException {
		return MyDataSource.getInstance(propPath).getDataSource().getConnection();//여기서 예외처리하지 X
	}
}
