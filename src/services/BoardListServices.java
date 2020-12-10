package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListServices {

	public int BoardCount() {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		int boardCount = dao2.BoardCount();
		
		
		close(con);
		
		return boardCount;
	}

	public ArrayList<BoardDTO> BoardList(int startRow, int endRow) {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		ArrayList<BoardDTO> list = dao2.BoardList(startRow, endRow);
		close(con);
		
		return list;
	}

}
