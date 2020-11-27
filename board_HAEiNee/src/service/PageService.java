package service;

import static dao.DataAccessObject.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import Bean.BoardInfoBean;
import dao.DataAccessObject;

public class PageService {

	public int ListCount() {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int listCount = dao.ListCount();
		close(con);
		return listCount;
	}

	public ArrayList<BoardInfoBean> BoardList(int startRow, int endRow) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		ArrayList<BoardInfoBean> al = dao.BoardList(startRow, endRow);
		close(con);
		return al;
	}

}
