package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardMyWriteListServices {

	public int MyBoardCount(String userNick) {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		int boardCount = dao2.MyBoardCount(userNick);
		close(con);
	
		return boardCount;
	}

	public ArrayList<BoardDTO> MyBoardList(int startRow, int endRow, String userNick) {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		ArrayList<BoardDTO> list = dao2.MyBoardList(startRow, endRow, userNick);
		close(con);
	
		return list;
	}

}
