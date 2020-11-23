package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;
import service.DelService;
import service.ViewService;

/**
 * Servlet implementation class DelController
 */
@WebServlet("/memberDel")
public class DelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelController() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String userId1 = request.getParameter("userId1");
		System.out.println("del id :" + userId1);
		DelService delsvc = new DelService();
		
		int delResult = delsvc.memberDel(userId1);
		if(delResult>0) {
			response.sendRedirect("Main.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

}
