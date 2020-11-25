package service;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*
;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class WriteService {

	public int bWrite(BoardDTO board) {
		System.out.println("2.service");
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int writeResult = dao.bWrite(board);
		System.out.println("6.service : " + writeResult);
		
		if(writeResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return writeResult;
	}

}
