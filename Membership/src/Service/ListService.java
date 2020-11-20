package Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DAO.memberDAO;

import static DAO.memberDAO.*;
import static DB.jdbcUtil.*;

import DTO.DTO2;

public class ListService {
	memberDAO dao = getInstance();
	Connection con = getConnection();
	
	public List<DTO2> memberList() {
		dao.setConnection(con);
		List<DTO2> list = new ArrayList<DTO2>();
		list = dao.memberList();
		return list;
	}

}