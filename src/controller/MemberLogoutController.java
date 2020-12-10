package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.MemberHistoryServices;


@WebServlet("/memberLogout")
public class MemberLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberLogoutController() {
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
		int logout = -1;
		String id = request.getParameter("id");
		
		System.out.println(id);
		MemberHistoryServices mhs = new MemberHistoryServices();
		mhs.logOutHistory(id, logout);
	
		HttpSession ss = request.getSession();
	
		ss.invalidate();
		PrintWriter out = response.getWriter();
		out.println("<script>alert('아웃.!!');</script>");
		out.println("<script>location.href='index.html';</script>");
		
	
	
	}
}
