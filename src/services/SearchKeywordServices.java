package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;

public class SearchKeywordServices {

	public ArrayList<BoardDTO> serch(String serch) {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		ArrayList<BoardDTO> list = dao2.serch(serch);
		close(con);
		return list;
	}

}
