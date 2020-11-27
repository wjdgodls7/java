package service;

import static dao.DataAccessObject.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import Bean.UserInfoBean;

import dao.DataAccessObject;

public class MemberServiceJoin {

	public boolean memberJoin(UserInfoBean uib) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		boolean result = false;
		result = dao.memberJoin(uib);
		
		if (result) {
			commit(con);
			close(con);
		}else {
			rollback(con);
			close(con);
		}
	
		return result;
	}
	
}
