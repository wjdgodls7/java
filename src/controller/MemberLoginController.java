package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import services.MemberHistoryServices;
import services.MemberLoginServices;


@WebServlet("/memberLogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLoginController() {
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
		String userNick=null;
		MemberDTO dto = new MemberDTO();
		int login = 1;

		dto.setUserId(request.getParameter("id"));
		dto.setUserPw(request.getParameter("pw"));
		
		MemberLoginServices mls = new MemberLoginServices();
		MemberHistoryServices mhs = new MemberHistoryServices();
		userNick = mls.logIn(dto);
		mhs.logInHistory(dto,login);
		HttpSession ss = request.getSession();

		if (userNick!=null) {			
			ss.setAttribute("nick", userNick);
			ss.setAttribute("Level", dto.getUserLevel());
			ss.setAttribute("id", dto.getUserId());
			response.sendRedirect("Main.jsp");
		}else {
			ss.invalidate();
			PrintWriter out = response.getWriter();
			out.println("<script>alert('땡.!!');</script>");
			out.println("<script>location.href='index.html';</script>");
		}




	}
}
