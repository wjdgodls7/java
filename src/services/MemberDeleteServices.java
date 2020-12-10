package services;

import static dao.MemberDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberDeleteServices {

	public int memberDelete(String id, String nick) {
		// 공통부분
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		System.out.println(id);
		System.out.println(nick);
		
		int result = dao.memberDelete(id,nick);
		
		System.out.println(result);
		if (result>0) {
			commit(con);
		}else {rollback(con);}
		close(con);
		
		return result;
	}

}
