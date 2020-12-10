package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.BoardDeleteServices;

/**
 * Servlet implementation class MemberWriteDeleteController
 */
@WebServlet("/writeDelete")
public class BoardWriteDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int Num = Integer.parseInt(request.getParameter("num"));
		String nick = request.getParameter("nick");
		String loginnick = request.getParameter("loginnick");
		String level = request.getParameter("level");


		BoardDeleteServices delsvc = new BoardDeleteServices();

		System.out.println(Num);
		PrintWriter out = response.getWriter();
		
		System.out.println(loginnick);
		System.out.println(nick);
		System.out.println(level);
		
		
		if(level.equals("M")) {
			int delResult = delsvc.BoardDel(Num);
			if(delResult > 0) {
				out.println("<script>alert('글 삭제 성공!');</script>");
				out.println("<script>location.href='writeList';</script>");
			}else {
				out.println("<script>alert('글 삭제 실패!');</script>");
				out.println("<script>location.href='writeList';</script>");
			}
		}else if (level.equals("S")) {
			int delResult = delsvc.BoardDel(Num);
			System.out.println(delResult);
			if(delResult>0) { 
				out.println("<script>alert('글 삭제 성공!');</script>");
				out.println("<script>location.href='writeList';</script>");
			} else {
					out.println("<script>alert('권한이 없습니다 !');</script>");
					out.println("<script>location.href='writeList';</script>");
			} 				
		}
		
		/*
		 * if(level.equals("S")) {
		 * 
		 * }
		 */


	}

}
