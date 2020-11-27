package service;

import static dao.DataAccessObject.getInstance;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.DataAccessObject;

public class DelMember {

	public int delMember(String name, String nick) {
		// 공통부분
				DataAccessObject dao = getInstance();
				Connection con = getConnection();
				dao.setConnection(con);
				// 여기까지
				int result;
				result = dao.delMember(name,nick);
				if (result>0) {
					commit(con);
					close(con);
				}else {
					rollback(con);
					close(con);
				}
				return result;
	}

}
