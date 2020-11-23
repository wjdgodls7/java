package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.memberDAO;
import dto.memberDTO;
import static db.JdbcUtil.*;
import static dao.memberDAO.*;

public class ListService {

	public ArrayList<memberDTO> memberList() {
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ArrayList<memberDTO> memberList = new ArrayList<memberDTO>();
		memberList = dao.memberList();
		close(con);
		
		return memberList;
	}

}











