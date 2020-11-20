package Service;

import DAO.memberDAO;
import DTO.DTO2;
import static DAO.memberDAO.*;
import static DB.jdbcUtil.*;

import java.sql.Connection;

public class memberService {
	memberDAO dao = getInstance();
	Connection con = getConnection();
		
	public int memberJoin(DTO2 member) {
		dao.setConnection(con);	
		
		int result = dao.memberJoin(member);
		
		if (result>0) {
			commit(con);
			
		}else {rollback(con);}
		
		close(con);
		return result;
	}

}