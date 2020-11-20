package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login1() {
		super();

	}

	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormResult.jsp");

		String sId = request.getParameter("sId");
		String sPwd = request.getParameter("sPwd");

		request.setAttribute("sId", sId);
		request.setAttribute("sPwd", sPwd);

		dispatcher.forward(request, response);

		//Redirect 방식
		
//		response.sendRedirect("FormResult.jsp");
				
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doprocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doprocess(request, response);
	}

}
