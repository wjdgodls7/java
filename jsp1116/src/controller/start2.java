package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class start2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public start2() {
		super();

	}

	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=utf-8");

//		이동할 JSP를 설정해 주는 dispatcher 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormResult.jsp");
		
		String sName = request.getParameter("sName");
		String sid = request.getParameter("sid");
		System.out.println("이름 : " + sName);
		System.out.println("아이디 : " + sid);
		
		//정보를 담기
		request.setAttribute("sName1", sName);
		request.setAttribute("sid1", sid);
		request.setAttribute("sInfo1", "에베베베베벱");
		//Attribute = 다양한 데이터 타입 입력 가능
		
		//담긴 정보를 jsp로 보내주기
		dispatcher.forward(request, response);
		
		PrintWriter out = response.getWriter();
		//html의 body부분이라고 생각하면 된다.
//		out.println("<h1>학생 정보 받아오기<h1/>");
//		out.println("<h3>이름 : " + sName + "<h3/>");
//		out.println("<h3>아이디 : " + sid + "<h3/>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget");
		doprocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doprocess(request, response);
	}

}