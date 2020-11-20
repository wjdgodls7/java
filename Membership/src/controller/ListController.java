package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DTO2;
import Service.ListService;


@WebServlet("/MemberList")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListController() {
        super();
    
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		List<DTO2> list = new ArrayList<DTO2>();
		ListService listsv = new ListService();
		list = listsv.memberList();
		System.out.println(list.get(0).getUserId());
		
		request.setAttribute("member1", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberList.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

}
