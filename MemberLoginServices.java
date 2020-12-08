package services;

import static dao.MemberDAO.*;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberLoginServices {

	public String logIn(MemberDTO dto) {
		// 공통부분
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		String userNick = null;
			
		userNick = dao.logIn(dto);
		close(con);
		
		return userNick;
	}

}
