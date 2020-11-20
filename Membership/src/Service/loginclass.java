package Service;

import static DAO.memberDAO.*;
import static DB.jdbcUtil.*;

import java.sql.Connection;

import DAO.memberDAO;
import DTO.DTO2;

public class loginclass {
	
	
	public String loginInfo(DTO2 dto) {
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String result = dao.loginInfo(dto);
		
		close(con);
								
		return result;
	}

}
