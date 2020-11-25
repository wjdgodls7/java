package service;

import static dao.BoardDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;

public class ListService {

	public ArrayList<BoardDTO> BoardList() {
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		ArrayList<BoardDTO> boardlist = dao.BoardList();
		close(con);
		
		return boardlist;
	}

}







