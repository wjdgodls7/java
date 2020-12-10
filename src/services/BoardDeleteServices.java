package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.BoardDAO;

public class BoardDeleteServices {

	public int BoardDel(int Num) {
		// 공통부분
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		// 여기까지
		
		int delResult = dao2.BoardDel(Num);

		if(delResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		System.out.println("boardDeleteService :" + delResult);
		return delResult;
	}


}
