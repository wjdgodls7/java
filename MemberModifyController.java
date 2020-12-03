package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import services.MemberModifyServices;


@WebServlet("/memberModify")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberModifyController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int result = 0;
		
		String id = request.getParameter("id");
    	String nick = request.getParameter("nick");
    	String name = request.getParameter("name");
    	String birth = request.getParameter("birthyy")+request.getParameter("birthmm")+request.getParameter("birthdd");
    	String gender = request.getParameter("gender");
    	String phone = request.getParameter("phone");
    	String add = request.getParameter("add");
    	String email = request.getParameter("email");
    	String team = request.getParameter("team");
    	
    	MemberDTO member = new MemberDTO();
    	
    	System.out.println(id);
    	System.out.println(nick);

    	member.setUserNick(nick);
    	member.setUserName(name);
    	member.setUserTeam(team);
    	member.setUserBirth(birth);
    	member.setUserGender(gender);
    	member.setUserPhone(phone);
    	member.setUserAdd(add);
    	member.setUserEmail(email);
		
    	MemberModifyServices mms = new MemberModifyServices();
    	result = mms.memberModi(id, member);
    	if (result>0) {
			response.sendRedirect("Main.jsp");
		}else {
			response.sendRedirect("MemberDeleteForm.jsp");
		}
	}
}
