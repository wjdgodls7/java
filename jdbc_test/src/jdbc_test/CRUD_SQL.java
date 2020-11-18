package jdbc_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CRUD_SQL {

	// DB������ ���� ���� con ����
	Connection con = null;

	// ������ �����ϱ� ���� ���� ����
	Statement stmt = null;			// sql���� db�� �����ϱ� ���� ����
	PreparedStatement pstmt = null; // ? �� ���ڷ� �ν��ϱ� ���� ����
	ResultSet rs =null;

	// 1. DB����
	public void connect() {
		con = DB.DBconnect();
		// DBC�� �ִ� DBconnect()�� �����´�.

	}

	// 2. DB���� ����
	public void conClose() {
		try {
			con.close();
			System.out.println("DB���� ����!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 3. �л����
	public void stuJoin(CRUD_DTO stu) {
		String sql = "INSERT INTO STUTABLE VALUES(?,?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, stu.getStuName());
			pstmt.setInt(2, stu.getStAge());
			// ù��° ����ǥ�� stu.getStuName() ����
			// �ι�° ����ǥ�� stu.getStuAge() ����

			pstmt.executeUpdate();			

			System.out.println("�л� ��� ����!");
		} catch (SQLException e) {
			System.out.println("�л� ��� ����!");
			e.printStackTrace();
		}
	}

	//4. �л� ��ȸ
	public void select() {
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM STUTABLE";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				System.out.println("�̸� : " + rs.getString(1));
				System.out.println("���� : " + rs.getInt(2));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void modify(String name, String name2, int age) {
		try {
			stmt = con.createStatement();
			String sql = "UPDATE STUTABLE SET STUAGE = ? , STUNAME = ? WHERE STUNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2,name2);
			pstmt.setString(3,name);

			pstmt.executeUpdate();
			System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void delete(String name) {
		try {
			stmt = con.createStatement();
			String sql = "DELETE FROM STUTABLE WHERE STUNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			pstmt.executeUpdate();
			System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}


