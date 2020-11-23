package service;

import static dao.memberDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.memberDAO;
import dto.memberDTO;

public class ProcessService {

	public int mPro(memberDTO mProcess) {
		// 공통부분
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int proResult = dao.mPro(mProcess);

		
		if(proResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return proResult;
	}

}
