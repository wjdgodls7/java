package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteServices {

	public int Write(BoardDTO board) {
		System.out.println("2.service");
		// 공통부분
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		// 여기까지
		
		int writeResult = dao2.Write(board);
		System.out.println("6.service : " + writeResult);
		
		if(writeResult>0) {
			commit(con);
			close(con);
		} else {
			rollback(con);
			close(con);
		}
		
		return writeResult;
	}

}
