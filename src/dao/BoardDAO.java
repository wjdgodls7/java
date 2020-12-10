package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardDTO;

import static db.JdbcUtil.*;

public class BoardDAO {
	private static BoardDAO dao2;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// getInstance메소드
	public static BoardDAO getInstance() {
		if (dao2 == null) {
			dao2 = new BoardDAO();
		}
		return dao2;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int Write(BoardDTO board) {
		System.out.println("3.dao");
		String sql = "INSERT INTO BOARD VALUES (?,SEQ_5TH.NEXTVAL,?,?,?,0,?,SYSDATE,?)";
		

		int writeResult = 0;

		try {
			System.out.println("4.DB");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getNick());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFile());
			pstmt.setString(6, board.getId());
			
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println(board.getNick());
		System.out.println(board.getSubject());
		System.out.println("5.dao : " + writeResult);
		return writeResult;
	}

	public int BoardDel(int Num) {
		int delResult = 0;
		String sql = "DELETE BOARD WHERE BOARD_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Num);
			delResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println("boardDAO :" + delResult);
		return delResult;
	}


	public int BoardCount() {
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		int boardCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardCount;
	}

	public ArrayList<BoardDTO> BoardList(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setNick(rs.getNString(1));
				dto.setNum(rs.getInt(2));
				dto.setSubject(rs.getNString(3));
				dto.setTitle(rs.getNString(4));
				dto.setContent(rs.getNString(5));
				dto.setHit(rs.getInt(6));
				dto.setFile(rs.getNString(7));
				dto.setDate(rs.getNString(8));
				dto.setId(rs.getNString(9));
				
			
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
	
		return list;
	}

	public BoardDTO BoardDetail(int num) {
		String sql = "SELECT * FROM BOARD WHERE BOARD_NUM = ?";
		BoardDTO dto = new BoardDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNick(rs.getNString(1));
				dto.setNum(rs.getInt(2));
				dto.setSubject(rs.getNString(3));
				dto.setTitle(rs.getNString(4));
				dto.setContent(rs.getNString(5));
				dto.setHit(rs.getInt(6));
				dto.setFile(rs.getNString(7));
				dto.setDate(rs.getNString(8));
				dto.setId(rs.getNString(9));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return dto;
	}

	public int BoardHit(int num) {
		String sql = "UPDATE BOARD SET BOARD_HIT = BOARD_HIT+1 WHERE BOARD_NUM = ? ";
		int hit = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			hit = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return hit;
	}

	public int MyBoardCount(String userNick) {
		String sql = "SELECT COUNT(*) FROM BOARD WHERE BOARD_NICK = ?";
		int boardCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, userNick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardCount;
	}

	public ArrayList<BoardDTO> MyBoardList(int startRow, int endRow, String userNick) {
		String sql = "SELECT * FROM (SELECT BOARDLIST.*, ROW_NUMBER() OVER(ORDER BY BOARD_NUM DESC) AS RN FROM(SELECT * FROM BOARD WHERE BOARD_NICK =?)BOARDLIST) WHERE RN BETWEEN ? AND ?";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userNick);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			System.out.println(userNick + startRow + endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setNick(rs.getNString(1));
				dto.setNum(rs.getInt(2));
				dto.setSubject(rs.getNString(3));
				dto.setTitle(rs.getNString(4));
				dto.setContent(rs.getNString(5));
				dto.setHit(rs.getInt(6));
				dto.setFile(rs.getNString(7));
				dto.setDate(rs.getNString(8));
				dto.setId(rs.getNString(9));
				
			
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
	
		return list;
	}

	public int modify(BoardDTO board, int bnum) {
		String sql = "UPDATE BOARD SET BOARD_SUBJECT=?, BOARD_TITLE =?, BOARD_CONTENT=?, BOARD_FILE=? WHERE BOARD_NUM=?";
		int result=0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, board.getSubject());
			pstmt.setNString(2, board.getTitle());
			pstmt.setNString(3, board.getContent());
			pstmt.setNString(4, board.getFile());
			pstmt.setInt(5, bnum);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<BoardDTO> serch(String serch) {
	String sql = "SELECT * FROM BOARDLIST WHERE BOARD_TITLE LIKE '%'||?||'%'";
	ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
	int result=0;
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setNString(1, serch);
		rs= pstmt.executeQuery();
		
		if (rs.next()) {
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNick(rs.getNString(1));
			dto.setNum(rs.getInt(2));
			dto.setSubject(rs.getNString(3));
			dto.setTitle(rs.getNString(4));
			dto.setDate(rs.getNString(8));
			dto.setHit(6);
			list.add(dto);
			result=1;
		}
		}else {result=0;};
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
		return list;
	}
}
