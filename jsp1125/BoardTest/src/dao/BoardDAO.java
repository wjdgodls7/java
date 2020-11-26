package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// getInstance메소드
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글작성하기
	public int bWrite(BoardDTO board) {
		System.out.println("3.dao");
		String sql = "INSERT INTO BOARDT VALUES(SEQ_DAN.NEXTVAL,?,?,?,?,SYSDATE,0,?)";
		int writeResult = 0;

		try {
			System.out.println("4.DB");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbTitle());
			pstmt.setString(4, board.getbContent());
			pstmt.setString(5, board.getbFile());
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("5.dao : " + writeResult);
		return writeResult;
	}

	public ArrayList<BoardDTO> BoardList() {
		String sql = "SELECT * FROM BOARDT";

		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardDTO();

				board.setbNum(rs.getInt(1));
				board.setbWriter(rs.getString(2));
				board.setbPassword(rs.getString(3));
				board.setbTitle(rs.getString(4));
				board.setbContent(rs.getString(5));
				board.setbDate(rs.getString(6));
				board.setbHit(rs.getInt(7));
				board.setbFile(rs.getString(8));

				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardlist;
	}

	public int BoardDel(int bNum) {
		int delResult = 0;
		String sql = "DELETE BOARDT WHERE BNUM=?";

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

	public BoardDTO BoardView(int bNum) {
		BoardDTO board = new BoardDTO();
		String sql = "SELECT * FROM BOARDT WHERE BNUM = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board.setbNum(rs.getInt(1));
				board.setbWriter(rs.getString(2));
				board.setbPassword(rs.getString(3));
				board.setbTitle(rs.getString(4));
				board.setbContent(rs.getString(5));
				board.setbDate(rs.getString(6));
				board.setbHit(rs.getInt(7));
				board.setbFile(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println("dao :: " + board.toString());
		return board;
	}

	public int modiPro(BoardDTO board) {
		String sql = "UPDATE BOARDT SET BWRITER=?, BPASSWORD=?, BTITLE=?, BCONTENT=? WHERE BNUM=?";
		int proResult = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbTitle());
			pstmt.setString(4, board.getbContent());
			pstmt.setInt(5, board.getbNum());
			proResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return proResult;
	}

	public int BoardBhit(int bNum) {
		String sql = "UPDATE BOARDT SET BHIT = BHIT+1 WHERE BNUM=?";
		int hitResult = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			hitResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return hitResult;
	}

	public int ListCount() {
		String sql = "SELECT COUNT(*) FROM BOARDT";
		int listCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return listCount;
	}

	public ArrayList<BoardDTO> BoardList(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardDTO();

				board.setbNum(rs.getInt(1));
				board.setbWriter(rs.getString(2));
				board.setbPassword(rs.getString(3));
				board.setbTitle(rs.getString(4));
				board.setbContent(rs.getString(5));
				board.setbDate(rs.getString(6));
				board.setbHit(rs.getInt(7));
				board.setbFile(rs.getString(8));

				boardList.add(board);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return boardList;
	}
}
