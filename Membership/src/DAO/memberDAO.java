package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.jdbcUtil.*;
import DTO.DTO2;

public class memberDAO {
	private static memberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static memberDAO getInstance() {		
		if(dao==null) {
			dao = new memberDAO();
		}
		return dao;
	}
	//setConnection
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int memberJoin(DTO2 member) {
		String sql = "INSERT INTO MEMBERT VALUES(?,?,?,?,?,?)";
		int result =0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, member.getUserId());
			pstmt.setNString(2, member.getUserPw());
			pstmt.setNString(3, member.getUserName());
			pstmt.setNString(4, member.getUserBirth());
			pstmt.setNString(5, member.getUserEmail());
			pstmt.setNString(6, member.getUserGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public List<DTO2> memberList() {		
		List<DTO2> list = new ArrayList<DTO2>();
		String sql = "SELECT * FROM MEMBERT";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO2 member = new DTO2();
				member.setUserId(rs.getNString(1));
				member.setUserPw(rs.getNString(2));
				member.setUserName(rs.getNString(3));
				member.setUserBirth(rs.getNString(4));
				member.setUserGender(rs.getNString(5));
				member.setUserEmail(rs.getNString(6));
				list.add(member);
			}
			System.out.println(list.get(0).getUserId());
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return list;
	}
	public String loginInfo(DTO2 dto) {
		String sql = "SELECT USERID FROM MEMBERT WHERE USERID=? AND USERPWD=?";
		String loginId = null;
		try {
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, dto.getUserId());
			pstmt.setNString(2, dto.getUserPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginId=rs.getNString(1);
			}else {loginId=null;}
			System.out.println(loginId);
		} catch (SQLException e) {

			e.printStackTrace();
		} 			
		return loginId;
	}
}