package service;

import dao.memberDAO;
import dto.memberDTO;

import static dao.memberDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class memberService {

	memberDAO dao = getInstance();
	Connection con = getConnection();
	
	public int memberJoin(memberDTO member) {
		System.out.println("2.service");
		dao.setConnection(con);
		
		int result = dao.memberJoin(member);
		// dao에서 return 받은 값
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		System.out.println("6.service : " + result);
		return result;
	}

}







