package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	public static Connection DBconnect() {
		Connection con = null;

		String url = "jdbc:oracle:thin:@192.168.0.212:1521:XE";
		String user = "JHI";
		String password = "0000";
		
		try {
			//ODJBC6 파일 현재 소스에 적용
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//CON에 정보를 저장
			con = DriverManager.getConnection(url, user, password);

			System.out.println("접속성공");
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB접속 실패 : 드라이버");
		} catch (SQLException se) {
			se. printStackTrace();
			System.out.println("DB접속 실패 : DB계정");
		}
		return con;
	}

}
