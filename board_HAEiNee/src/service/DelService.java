package service;

import static dao.DataAccessObject.getInstance;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import java.sql.Connection;
import dao.DataAccessObject;

public class DelService {
	public void BoardDel(int bNum) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int delResult = dao.BoardDel(bNum);

		if(delResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
	}

}
