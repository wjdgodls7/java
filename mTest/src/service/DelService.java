package service;

import static dao.memberDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.memberDAO;

public class DelService {

	public int memberDel(String userId1) {
		// 공통부분
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int delResult = dao.memberDel(userId1);
		
		if(delResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		return delResult;
	}

}
