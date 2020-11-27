package service;

import static dao.DataAccessObject.*;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Bean.UserInfoBean;
import dao.DataAccessObject;

public class ListService {

	public ArrayList<UserInfoBean> memberList() {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		ArrayList<UserInfoBean> al = dao.MemberList();
		
		if(al!=null) {
			commit(con);
			close(con);
		}else {
			rollback(con);
			close(con);
		}
		return al;
	}
	
	public UserInfoBean detail(String name, String nick) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		UserInfoBean uib = dao.detail(name,nick);
	
		if (uib.getMemberId()!=null) {
			commit(con);
			close(con);
		}else {
			rollback(con);
			close(con);
		}
		return uib;
	}






}
