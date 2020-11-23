package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;
import service.memberService;


@WebServlet("/memberJoin")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public joinController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.controller");
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// jsp에서 받아온 정보들
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		// dto와 service import
		memberDTO member = new memberDTO();
		memberService joinsvc = new memberService();
		
		// jsp에서 넘어온 정보를
		// dto 타입인 member에 저장
		member.setUserId1(userId);
		member.setUserPw(userPw);
		member.setUserName(userName);
		member.setUserBirth(userBirth);
		member.setUserGender(userGender);
		member.setUserEmail(userEmail);
		
		// member의 정보를 가지고 service로 이동
		int result = joinsvc.memberJoin(member);
		// service에서 return 받은 값
		
		
		System.out.println("7.controller : " + result);
		if(result>0) {
			response.sendRedirect("joinSuccess.jsp");
		} else {
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
