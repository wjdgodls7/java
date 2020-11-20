package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=utf-8");
		
		String sId = request.getParameter("sId");
		String sPwd = request.getParameter("sPwd");

		System.out.println(sId);
		System.out.println(sPwd);

		PrintWriter out = response.getWriter();
		out.println("<h1>학생 정보 받아오기<h1/>");
		out.println("<td>아이디 : " + sId + "<td/><br/>");
		out.println("<td>비밀번호 : " + sPwd + "<td/>");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doprocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doprocess(request, response);
	}

}