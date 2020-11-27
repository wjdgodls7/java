package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BoardInfoBean;
import service.ModiService;


@WebServlet("/realModi")
public class RealModi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RealModi() {
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

		BoardInfoBean board = new BoardInfoBean();
		board.setbNum(Integer.parseInt(request.getParameter("bNum")));
		board.setBwriter(request.getParameter("bWriter"));
		board.setbTitle(request.getParameter("bTitle"));
		board.setbContent(request.getParameter("bContent"));

		ModiService prosvc = new ModiService();
		int proResult = prosvc.modi(board);

		if(proResult>0) {
			response.sendRedirect("paging");
		} else {
			response.sendRedirect("ModiForm.jsp");
		}
	}
}