package service;

import static dao.DataAccessObject.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import Bean.BoardInfoBean;
import dao.DataAccessObject;

public class WriteService {

	public int Write(BoardInfoBean bib) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지

		int result = dao.Write(bib);
		if (result>0) {
			commit(con);
			close(con);
		}else {
			commit(con);
			close(con);
		}
		return result;

	}

}
