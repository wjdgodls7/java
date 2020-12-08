package services;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberIdCheckService {

	public int membeIdCheck(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = 0;
		
		result =dao.idCheck(id);
		close(con);
		
		return result;
	}

}
