package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import services.BoardWriteServices;

/**
 * Servlet implementation class MemberWriteController
 */
@WebServlet("/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);	
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.controller");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파일업로드 설정부분
		int size = 10 * 1024 * 1024; // 파일 용량 10MB
		String savePath = "C:/Users/GG/Documents/5thSEMI/5thBoard/WebContent/FileUpload"; // 저장경로
		
		MultipartRequest multi = new MultipartRequest(
				request,	// 담아온 정보 사용하기 위해
				savePath,	// 저장경로
				size,		// 용량
				"UTF-8",	// 인코딩방식
				new DefaultFileRenamePolicy() // 중복된 파일 이름 바꾸기
				// img, img(1), img2
		);
		
		BoardDTO board = new BoardDTO();
		
		board.setNick(multi.getParameter("nick"));
		//board.setNum(dao.getSeq());
		board.setSubject(multi.getParameter("subject"));
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		board.setId(multi.getParameter("id"));

		System.out.println("1-1" + board.toString());
		
		BoardWriteServices writesvc = new BoardWriteServices();
		int writeResult = writesvc.Write(board);
		System.out.println("7.controller : " + writeResult);
		PrintWriter out = response.getWriter();
		if(writeResult>0) {
			out.println("<script>alert('글 작성 성공!');</script>");
			out.println("<script>location.href='writeList';</script>");
		} else {
			response.sendRedirect("BoardWriteFail.jsp");
		}
	}
}
