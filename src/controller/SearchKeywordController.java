package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import services.SearchKeywordServices;


@WebServlet("/serachKeyword")
public class SearchKeywordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchKeywordController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String serch = request.getParameter("serch");
		System.out.println(serch);
		SearchKeywordServices sks = new SearchKeywordServices();
		ArrayList<BoardDTO> list = sks.serch(serch);
		
		if (list.size()>0) {
			RequestDispatcher rd = request.getRequestDispatcher("SearchForm.jsp");
			request.setAttribute("boardList", list);
			rd.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('검색결과가 없습니다.');</script>");
			out.println("<script>location.href='writeList';</script>");
			
		}
		
		
	}
}
