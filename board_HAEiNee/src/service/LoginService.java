package service;

import static dao.DataAccessObject.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import Bean.UserInfoBean;
import dao.DataAccessObject;

public class LoginService {

	public void logIn(UserInfoBean uif) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		dao.login(uif);
		if (uif.getMemberName()!=null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
	}
}
