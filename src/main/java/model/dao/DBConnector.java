package model.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnector {
 //database접속을 위한 connection singleton방식으로
	private static DBConnector instance = new DBConnector();
	private DBConnector() {}
	
	public static DBConnector getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception {
		//data base 연결하기 위한 드라이버 호출
		Context initCtx = new InitialContext();
		DataSource ds = 
				(DataSource)initCtx.lookup("java:comp/env/jdbc/bitdb");
		return ds.getConnection();
	}
}
