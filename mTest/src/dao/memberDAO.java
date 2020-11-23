package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dto.memberDTO;

public class memberDAO {

	private static memberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// getInstance메소드
	public static memberDAO getInstance() {
		if (dao == null) {
			dao = new memberDAO();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	// 회원가입 dao
	public int memberJoin(memberDTO member) {
		System.out.println("3.dao");
		String sql = "INSERT INTO MEMBERT VALUES(?,?,?,?,?,?)";
		int result = 0;

		try {
			System.out.println("4.db");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserId1());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserBirth());
			pstmt.setString(5, member.getUserGender());
			pstmt.setString(6, member.getUserEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("5.dao : " + result);
		return result;
	}

	public ArrayList<memberDTO> memberList() {
		ArrayList<memberDTO> memeberList = new ArrayList<memberDTO>();
		memberDTO member = null;

		String sql = "SELECT * FROM MEMBERT";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				member = new memberDTO();
				
				member.setUserId1(rs.getString(1));
				member.setUserPw(rs.getString(2));
				member.setUserName(rs.getString(3));
				member.setUserBirth(rs.getString(4));
				member.setUserGender(rs.getString(5));
				member.setUserEmail(rs.getString(6));
				
				memeberList.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return memeberList;
	}

	public String memberLogin(memberDTO member) {
		String sql = "SELECT USERID "
				   + "FROM MEMBERT "
				   + "WHERE USERID=? AND USERPW=?";
		String loginId = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserId1());
			pstmt.setString(2, member.getUserPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString(1);
			} else {
				loginId = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginId;
	}

	public memberDTO memberView(String userId1) {
		memberDTO memberView = new memberDTO();
		String sql = "SELECT * FROM MEMBERT WHERE USERID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId1);
			rs = pstmt.executeQuery();
			
			// while(rs.next())
			// if(rs.next())
			
			if(rs.next()) {
				memberView.setUserId1(rs.getString(1));
				memberView.setUserPw(rs.getString(2));
				memberView.setUserName(rs.getString(3));
				memberView.setUserBirth(rs.getString(4));
				memberView.setUserGender(rs.getString(5));
				memberView.setUserEmail(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberView;
	}

	public int mPro(memberDTO mProcess) {
		String sql = "UPDATE MEMBERT SET USERPW=?, USERNAME=?, "
			     +   "USERBIRTH=?, USERGENDER=?, USEREMAIL=?"
			     +   "WHERE USERID=?";
		int proResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mProcess.getUserPw());
			pstmt.setString(2, mProcess.getUserName());
			pstmt.setString(3, mProcess.getUserBirth());
			pstmt.setString(4, mProcess.getUserGender());
			pstmt.setString(5, mProcess.getUserEmail());
			pstmt.setString(6, mProcess.getUserId1());
			proResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return proResult;
	}

	public int memberDel(String userId1) {
		String sql = "DELETE FROM MEMBERT WHERE USERID = ?";
		int delResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId1);
			delResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delResult;
	}
}







