package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardModifyServices {

	public int modify(BoardDTO board, int bnum) {
		System.out.println("2.service");
		// 공통부분
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		// 여기까지
		
		int writeResult = dao2.modify(board,bnum);

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
