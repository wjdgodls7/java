package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.ProcessService;

/**
 * Servlet implementation class ProcessController
 */
@WebServlet("/modiProcess")
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		
		BoardDTO board = new BoardDTO();
		board.setbNum(Integer.parseInt(request.getParameter("bNum")));
		board.setbWriter(request.getParameter("bWriter"));
		board.setbPassword(request.getParameter("bPassword"));
		board.setbTitle(request.getParameter("bTitle"));
		board.setbContent(request.getParameter("bContent"));
		
		ProcessService prosvc = new ProcessService();
		int proResult = prosvc.modiPro(board);
		
		if(proResult>0) {
			response.sendRedirect("bList");
		} else {
			response.sendRedirect("BoardWrite.jsp");
		}
	}

}
