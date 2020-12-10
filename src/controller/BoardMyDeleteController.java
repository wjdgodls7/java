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
 * Servlet implementation class BoardMyDeleteController
 */
@WebServlet("/BoardMyDeleteController")
public class BoardMyDeleteController extends HttpServlet {
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
		BoardDeleteServices delsvc = new BoardDeleteServices();
		
		PrintWriter out = response.getWriter();
		
		int delResult = delsvc.BoardDel(Num);
		
		if(delResult>0) {
			out.println("<script>alert('글 삭제 성공!');</script>");
			out.println("<script>location.href='myWriteList';</script>");
		} else {
			response.sendRedirect("BoardWrite.jsp");
		}
		
	}

}
