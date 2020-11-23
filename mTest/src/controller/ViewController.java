package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;
import service.ViewService;


@WebServlet("/memberView")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewController() {
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
		// memberView?userId1=${mem.userId1}
		// memberView는 controller로 가는 주소
		// userId1은 input태그로 볼때 name속성
		// ${mem.userId1}는 input태그로 볼때 입력한 값 or value값
		System.out.println("userId1 : " + userId1);
		
		memberDTO memberView = new memberDTO();
		
		ViewService viewsvc = new ViewService();
		memberView = viewsvc.memberView(userId1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberView.jsp");
		request.setAttribute("memberView", memberView);
		dispatcher.forward(request, response);
		
	}

}








