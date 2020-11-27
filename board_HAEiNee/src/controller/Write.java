package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Bean.BoardInfoBean;
import service.WriteService;

@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Write() {
		super();

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int size = 10*1024*1024;
		String Path = "C:/Users/GG/Documents/SRP_Semi/board_HAEiNee/WebContent/fileupload";

		MultipartRequest multi = new MultipartRequest(
				request,
				Path,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		System.out.println(multi.getParameter("nick"));
		BoardInfoBean bib = new BoardInfoBean();
		bib.setbTitle(multi.getParameter("Title"));
		bib.setBwriter(multi.getParameter("nick"));
		bib.setbContent(multi.getParameter("Content"));
		bib.setbFile(multi.getParameter("File"));
		System.out.println("setbwriter : "+bib.getBwriter());

		WriteService ws = new WriteService();
		int result = ws.Write(bib);
		
		if (result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("paging");
			rd.forward(request, response);
		}else {
			response.sendRedirect("WriteList.jsp");
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
