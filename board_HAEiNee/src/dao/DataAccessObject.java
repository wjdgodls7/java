package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import Bean.BoardInfoBean;
import Bean.UserInfoBean;

public class DataAccessObject {
	private static DataAccessObject dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;


	// getInstance메소드
	public static DataAccessObject getInstance() {
		if (dao == null) {
			dao = new DataAccessObject();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	public void login(UserInfoBean uif) {
		String sql ="{CALL LOGINJHI(?,?,?,?)}";
		CallableStatement cs;
		try {
			cs =  con.prepareCall(sql);
			cs.setNString(1, uif.getMemberId());
			cs.setNString(2, uif.getMemberPwd());
			cs.registerOutParameter(3, Types.NVARCHAR);
			cs.registerOutParameter(4, Types.NVARCHAR);
			cs.execute();

			uif.setMemberName(cs.getNString(3));
			uif.setMemberEmail(cs.getNString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean memberJoin(UserInfoBean uib) {
		String sql = "INSERT INTO SEMIJHI VALUES(?,?,?,?,?,?)";
		boolean result = false;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, uib.getMemberId());
			pstmt.setNString(2, uib.getMemberPwd());
			pstmt.setNString(3, uib.getMemberName());
			pstmt.setNString(5, uib.getuserGender());
			pstmt.setNString(4, uib.getMemberAdd());
			pstmt.setNString(6, uib.getMemberEmail());
			result = (pstmt.executeUpdate()==1)? true:false;

		} catch (SQLException e) {
			e.printStackTrace();

		}finally{
			close(pstmt);
		}
		return result;
	}

	public ArrayList<UserInfoBean> MemberList() {
		String sql = "SELECT * FROM SEMIJHI";
		ArrayList<UserInfoBean> al = new ArrayList<UserInfoBean>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				UserInfoBean uib = new UserInfoBean();
				uib.setMemberId(rs.getNString(1));
				uib.setMemberName(rs.getNString(3));
				uib.setMemberAdd(rs.getNString(4));
				uib.setuserGender(rs.getNString(5));
				uib.setMemberEmail(rs.getNString(6));
				al.add(uib);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return al;
	}

	public UserInfoBean detail(String name, String nick) {
		String sql = "SELECT * FROM SEMIJHI WHERE USERNAME=? AND USERNICK=?";
		UserInfoBean uib = new UserInfoBean();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, name);
			pstmt.setNString(2, nick);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uib.setMemberId(rs.getNString(1));
				uib.setMemberPwd(rs.getNString(2));
				uib.setMemberName(rs.getNString(3));
				uib.setMemberAdd(rs.getNString(4));
				uib.setuserGender(rs.getNString(5));
				uib.setMemberEmail(rs.getNString(6));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return uib;
	}

	public int delMember(String name, String nick) {
		String sql="DELETE SEMIJHI WHERE USERNAME=? AND USERNICK=?";
		int result=0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, name);
			pstmt.setNString(2, nick);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int Write(BoardInfoBean bib) {
		String sql = "INSERT INTO BOARDJHI VALUES(SEQ_HAEiNee.NEXTVAL,?,?,?,SYSDATE,0,?)";
		int result =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, bib.getBwriter());
			pstmt.setNString(2, bib.getbTitle());
			pstmt.setNString(3, bib.getbContent());
			pstmt.setNString(4, bib.getbFile());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int ListCount() {
		String sql = "SELECT COUNT(*) FROM BOARDJHI";
		int result =0;
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public ArrayList<BoardInfoBean> BoardList(int startRow, int endRow) {
		String sql = "SELECT * FROM ORDERS WHERE NUMSS BETWEEN ? AND ?";
		ArrayList<BoardInfoBean> al = new ArrayList<BoardInfoBean>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardInfoBean bib = new BoardInfoBean();
				bib.setbNum(rs.getInt(1));
				bib.setBwriter(rs.getNString(2));
				bib.setbTitle(rs.getNString(3));
				bib.setbContent(rs.getNString(4));
				bib.setbDate(rs.getNString(5));
				bib.setbHit(rs.getInt(6));
				bib.setbFile(rs.getNString(7));

				al.add(bib);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return al;
	}
	public int BoardBhit(int bNum) {
		String sql = "UPDATE BOARDJHI SET HIT = HIT+1 WHERE NUMS=?";
		int hitResult = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			hitResult = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return hitResult;
	}

	public BoardInfoBean BoardView(int bNum) {
		String sql="SELECT * FROM BOARDJHI WHERE NUMS = ?";
		BoardInfoBean bib = new BoardInfoBean();
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bib.setbNum(rs.getInt(1));
				bib.setBwriter(rs.getNString(2));
				bib.setbTitle(rs.getNString(3));
				bib.setbContent(rs.getNString(4));
				bib.setbDate(rs.getNString(5));
				bib.setbHit(rs.getInt(6));
				bib.setbFile(rs.getString(7));				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return bib;
	}

	public int modiPro(BoardInfoBean board) {
		String sql = "UPDATE BOARDJHI SET WRITER=?, TITLE=?, CONTENTS=? WHERE NUMS=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getbTitle());
			pstmt.setString(3, board.getbContent());
			pstmt.setInt(4, board.getbNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int BoardDel(int bNum) {
		int delResult = 0;
		String sql = "DELETE BOARDJHI WHERE NUMS=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			delResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return delResult;
	}

}
