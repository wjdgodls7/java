package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DelService;

@WebServlet("/boardDel")
public class BoardDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardDel() {
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
		DelService delsvc = new DelService();
		delsvc.BoardDel(bNum);
		response.sendRedirect("paging");
		
		
	}
}
