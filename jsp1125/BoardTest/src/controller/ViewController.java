package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.ViewService;

@WebServlet("/boardView")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewController() {
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
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		String page = request.getParameter("page");
		ViewService viewsvc = new ViewService();
		BoardDTO  board = viewsvc.BoardView(bNum); 
		
		if(board != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardView.jsp");
			request.setAttribute("view", board);
			request.setAttribute("page", page);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("BoardWrite.jsp");
		}
		
	}

}
