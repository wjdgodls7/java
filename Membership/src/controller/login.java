package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.DTO2;
import Service.loginclass;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String result;
		
		DTO2 dto = new DTO2();
		dto.setUserId(request.getParameter("userId"));
		dto.setUserPw(request.getParameter("userPw"));

		loginclass lgc = new loginclass();
		result = lgc.loginInfo(dto);

		HttpSession session = request.getSession();
		
		if (result!=null) {
			session.setAttribute("loginId", result);
			response.sendRedirect("loginSuccess.jsp");
		}else {
			response.sendRedirect("loginfail.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
