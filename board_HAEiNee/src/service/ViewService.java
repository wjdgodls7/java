package service;

import static dao.DataAccessObject.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import Bean.BoardInfoBean;
import dao.DataAccessObject;


public class ViewService {

	public BoardInfoBean BoardView(int bNum) {
		// 공통부분
		DataAccessObject dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
			
		int hitResult = dao.BoardBhit(bNum);
		if(hitResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		BoardInfoBean board = dao.BoardView(bNum);
		close(con);
		return board;
	}
	}
