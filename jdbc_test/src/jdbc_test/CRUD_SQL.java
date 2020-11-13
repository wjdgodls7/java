package jdbc_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CRUD_SQL {

	// DB접속을 위한 변수 con 선언
		Connection con = null;
		
		// 쿼리문 전송하기 위한 변수 선언
		Statement stmt = null;			// sql문을 db로 전송하기 위한 변수
		PreparedStatement pstmt = null; // ? 를 문자로 인식하기 위한 변수
		ResultSet rs =null;
		
		// 1. DB접속
		public void connect() {
			con = DB.DBconnect();
			// DBC에 있는 DBconnect()를 가져온다.
			
		}

		// 2. DB접속 해제
		public void conClose() {
			try {
				con.close();
				System.out.println("DB접속 해제!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		// 3. 학생등록
		public void stuJoin(CRUD_DTO stu) {
			String sql = "INSERT INTO STUTABLE VALUES(?,?)";
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, stu.getStuName());
				pstmt.setInt(2, stu.getStAge());
				// 첫번째 물음표에 stu.getStuName() 값을
				// 두번째 물음표에 stu.getStuAge() 값을
				
				pstmt.executeUpdate();			
				
				System.out.println("학생 등록 성공!");
			} catch (SQLException e) {
				System.out.println("학생 등록 실패!");
				e.printStackTrace();
			}
		}
		
		//4. 학생 조회
		public void select() {
			try {
				stmt = con.createStatement();
				String sql = "SELECT * FROM STUTABLE";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					System.out.println("이름 : " + rs.getString(1));
					System.out.println("나이 : " + rs.getInt(2));
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
				System.out.println("수정 완료 되었습니다.");
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
					System.out.println("삭제 완료 되었습니다.");
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
			}
			
			
		}


