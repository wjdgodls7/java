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
			//ODJBC6 ���� ���� �ҽ��� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//CON�� ������ ����
			con = DriverManager.getConnection(url, user, password);

			System.out.println("���Ӽ���");
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB���� ���� : ����̹�");
		} catch (SQLException se) {
			se. printStackTrace();
			System.out.println("DB���� ���� : DB����");
		}
		return con;
	}

}
