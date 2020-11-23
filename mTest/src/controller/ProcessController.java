package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;
import service.ProcessService;
import service.ViewService;

/**
 * Servlet implementation class ProcessController
 */
@WebServlet("/modiProcess")
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProcessController() {
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
		
		memberDTO mProcess = new memberDTO();
		// String userId = request.getParameter("userId1");
		// mProcess.setUSerId1(userId);
		
		mProcess.setUserId1(request.getParameter("userId1"));
		mProcess.setUserPw(request.getParameter("userPw"));
		mProcess.setUserName(request.getParameter("userName"));
		mProcess.setUserBirth(request.getParameter("userBirth"));
		mProcess.setUserGender(request.getParameter("userGender"));
		mProcess.setUserEmail(request.getParameter("userEmail"));
		
		ProcessService prosvc = new ProcessService();
		int proResult = prosvc.mPro(mProcess);
		
		if(proResult>0) {
			response.sendRedirect("Main.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
		
		
	}

}
