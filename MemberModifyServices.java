package services;

import static dao.MemberDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberModifyServices {

	public int memberModi(String id,MemberDTO member) {
		// 공통부분
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		int result=0;
		result = dao.memberModi(id,member);
		System.out.println(result);
		if (result>0) {
			commit(con);
		}else {rollback(con);}
		close(con);
		return result;
	}

}
