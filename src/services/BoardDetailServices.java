package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardDetailServices {

	public BoardDTO BoardDetail(int num) {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		int hit = dao2.BoardHit(num);
		
		if(hit > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		
		BoardDTO dto = dao2.BoardDetail(num);
		
		close(con);
		
		return dto;
	}

}
