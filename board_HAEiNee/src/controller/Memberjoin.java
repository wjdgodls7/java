package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserInfoBean;
import service.MemberServiceJoin;

@WebServlet("/memberJoin")
public class Memberjoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Memberjoin() {
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
		
		boolean result = false;
		
		UserInfoBean uib = new UserInfoBean();
		uib.setMemberId(request.getParameter("userId"));
		uib.setMemberPwd(request.getParameter("userPwd"));
		uib.setMemberName(request.getParameter("userName"));
		uib.setMemberAdd(request.getParameter("userAdd"));
		uib.setuserGender(request.getParameter("userGender"));
		uib.setMemberEmail(request.getParameter("userEmail"));
		
		MemberServiceJoin mj = new MemberServiceJoin();
		
		result = mj.memberJoin(uib);
		
		if (result) {
			response.sendRedirect("lion.html");
		}else {
			response.sendRedirect("JoinFail.jsp");
		}
		
	}
	
}