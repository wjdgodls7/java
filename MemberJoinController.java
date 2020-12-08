package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import services.MemberJoinServices;

@WebServlet("/memberJoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String id = request.getParameter("id");
    	String nick = request.getParameter("nick");
    	String pw = request.getParameter("password");
    	String name = request.getParameter("name");
    	String birth = request.getParameter("birthyy");
    	String email = request.getParameter("email");
    	String gender = request.getParameter("gender");
    	String phone = request.getParameter("phone");
    	String add = request.getParameter("add") +" "+ request.getParameter("add2") + " " + request.getParameter("add3");
    	String team = request.getParameter("team");
		System.out.println(birth);

    	
    	MemberDTO member = new MemberDTO();
    	System.out.println(birth);
    	member.setUserId(id);
    	member.setUserNick(nick);
    	member.setUserPw(pw);
    	member.setUserName(name);
    	member.setUserTeam(team);
    	member.setUserBirth(birth);
    	member.setUserGender(gender);
    	member.setUserPhone(phone);
    	member.setUserAdd(add);
    	member.setUserEmail(email);
    	
    	MemberJoinServices mjs = new MemberJoinServices();
    	int result = mjs.memberJoin(member);
    	PrintWriter out = response.getWriter();
    	if(result > 0) {
    		out.println("<script>alert('SUCCESS!');</script>");
			out.println("<script>location.href='index.html';</script>");
    	} else {
    		out.println("<script>alert('FAIL!');</script>");
			out.println("<script>location.href='index.html';</script>");
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
