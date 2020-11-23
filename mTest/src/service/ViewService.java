package service;

import static dao.memberDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.memberDAO;
import dto.memberDTO;

public class ViewService {

	public memberDTO memberView(String userId1) {
		// 공통부분
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		memberDTO memberView = dao.memberView(userId1);
		close(con);
		
		return memberView;
	}

}
