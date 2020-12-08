package services;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberNickCheckService {

	public int MembeNickCheckService(String nick) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = 0;
		
		result =dao.NickCheck(nick);
		close(con);
		
		return result;
	}

}
