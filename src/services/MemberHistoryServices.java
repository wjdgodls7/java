package services;

import static dao.MemberDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberHistoryServices {

	public void logInHistory(MemberDTO dto, int login) {
		// 공통부분
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		int result = 0;

		result = dao.history(dto,login);
		if (result>0) {
			commit(con);
		}else {rollback(con);}
		close(con);
	}

	public void logOutHistory(String id, int logout) {
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		int result = 0;

		result = dao.history(id,logout);
		if (result>0) {
			commit(con);
		}else {rollback(con);}
		close(con);
		
	}

}
