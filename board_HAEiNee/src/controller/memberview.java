package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserInfoBean;
import service.ListService;

@WebServlet("/memberview")
public class memberview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberview() {
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
		
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		
		ListService ls = new ListService();
		UserInfoBean uib= ls.detail(name, nick);
		
		if (uib.getMemberId()!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			request.setAttribute("userId", uib.getMemberId());
			request.setAttribute("userPwd", uib.getMemberPwd());
			request.setAttribute("userName", uib.getMemberName());
			request.setAttribute("userGender", uib.getuserGender());
			request.setAttribute("userAdd", uib.getMemberAdd());
			request.setAttribute("userEmail", uib.getMemberEmail());
			rd.forward(request, response);
		}else {
			response.sendRedirect("nondetail.jsp");
		}	
	}
}