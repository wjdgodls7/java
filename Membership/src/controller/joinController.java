package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DTO2;
import Service.memberService;

@WebServlet("/memberJoin")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public joinController() {
		super();

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");

		DTO2 member = new DTO2();
		memberService joinsv = new memberService();

		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserBirth(userBirth);
		member.setUserEmail(userEmail);
		member.setUserName(userName);
		member.setUserGender(userGender);

		int result = joinsv.memberJoin(member);
		if(result>0) {
			response.sendRedirect("joinSuccess.jsp");
		}else {
			response.sendRedirect("joinFail.jsp");
			}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}