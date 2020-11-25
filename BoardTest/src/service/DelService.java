package service;

import static dao.BoardDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class DelService {

	public int BoardDel(int bNum) {
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int delResult = dao.BoardDel(bNum);

		if(delResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		
		return delResult;
	}

}
