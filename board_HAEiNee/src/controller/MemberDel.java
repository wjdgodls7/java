package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DelMember;
@WebServlet("/memberdel")
public class MemberDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDel() {
        super();

    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		DelMember dm = new DelMember();
		int result;
		
		result = dm.delMember(name,nick);
		if (result>0) {
			response.sendRedirect("MemberList");
		}else {
			response.sendRedirect("MemberList.jsp");
		}
		
		
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
