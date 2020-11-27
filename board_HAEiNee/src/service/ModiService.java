package service;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import static dao.DataAccessObject.*;
import static db.JdbcUtil.*;
import Bean.BoardInfoBean;
import dao.DataAccessObject;

public class ModiService {

	public int modi(BoardInfoBean board) {
		// 공통부분
				DataAccessObject dao = getInstance();
				Connection con = getConnection();
				dao.setConnection(con);
				// 여기까지
				
				int proResult = dao.modiPro(board);
				
				if(proResult>0) {
					commit(con);
				} else {
					rollback(con);
				}
				
				return proResult;
	}

}
