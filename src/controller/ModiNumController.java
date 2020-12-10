package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modiNumController")
public class ModiNumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ModiNumController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		System.out.println(bNum);

		RequestDispatcher rd = request.getRequestDispatcher("BoardModifyForm.jsp");
		request.setAttribute("bNum", bNum);
		rd.forward(request, response);
		
		
	}
	
	
}
