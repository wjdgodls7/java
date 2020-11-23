package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.memberDTO;
import service.LoginService;
import service.memberService;


@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// jsp에서 받아온 정보들
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// dto와 service import
		memberDTO member = new memberDTO();
		LoginService logsvc = new LoginService();
		
		// jsp에서 넘어온 정보를
		// dto 타입인 member에 저장
		member.setUserId1(userId);
		member.setUserPw(userPw);
		
		
		// member의 정보를 가지고 service로 이동
		String loginId = logsvc.memberLogin(member);
		// service에서 return 받은 값
		
		HttpSession session = request.getSession();
		
		
		if(loginId!=null) {
			session.setAttribute("loginId", loginId);
			response.sendRedirect("loginSuccess.jsp");
		} else {
			response.sendRedirect("loginFail.jsp");
		}
		
		// session 생성
		// session.setAttribute("name", value);
		
		// session 해제
		// session.invalidate();
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
