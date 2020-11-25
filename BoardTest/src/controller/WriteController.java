package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.WriteService;

@WebServlet("/boardWrite")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WriteController() {
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
		System.out.println("1.controller");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파일업로드 설정부분
		int size = 10 * 1024 * 1024; // 파일 용량 10MB
		String savePath = "D:/HoonZzang/BoardTest/WebContent/fileUpload"; // 저장경로
		
		MultipartRequest multi = new MultipartRequest(
				request,	// 담아온 정보 사용하기 위해
				savePath,	// 저장경로
				size,		// 용량
				"UTF-8",	// 인코딩방식
				new DefaultFileRenamePolicy() // 중복된 파일 이름 바꾸기
				// img, img(1), img2
		);
		
		
		BoardDTO board = new BoardDTO();
		
		board.setbWriter(multi.getParameter("bWriter"));
		board.setbPassword(multi.getParameter("bPassword"));
		board.setbTitle(multi.getParameter("bTitle"));
		board.setbContent(multi.getParameter("bContent"));
		board.setbFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		
		System.out.println("1-1." +board.toString());
		
		WriteService writesvc = new WriteService();
		int writeResult = writesvc.bWrite(board);
		System.out.println("7.controller : " + writeResult);
		
		if(writeResult>0) {
			response.sendRedirect("bList");
		} else {
			response.sendRedirect("WriteFail.jsp");
		}
	}

}
