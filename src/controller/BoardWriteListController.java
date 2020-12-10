package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.PageDTO;
import services.BoardListServices;

/**
 * Servlet implementation class MemberWriteListController
 */
@WebServlet("/writeList")
public class BoardWriteListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardWriteListController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		int page = 1;
		int limit = 5;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListServices boardlist = new BoardListServices();
		
		int boardCount = boardlist.BoardCount();
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		ArrayList<BoardDTO> list = boardlist.BoardList(startRow, endRow);
		
		int maxPage = (int)((double)boardCount / limit + 0.9);
		int startPage = (((int)((double)page / 5 + 0.9))-1)* 5 + 1;
		
		int endPage = startPage + 5 -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setBoardCount(boardCount);
		
		request.setAttribute("paging", paging);
		request.setAttribute("boardList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardList.jsp");
		dispatcher.forward(request, response);
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

}
