package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.UserInfoBean;
import service.LoginService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();

    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UserInfoBean uif = new UserInfoBean();
		
		uif.setMemberId(request.getParameter("identify"));
		uif.setMemberPwd(request.getParameter("password"));
		System.out.println(uif.getMemberId());
		LoginService lsv = new LoginService();
		lsv.logIn(uif);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("name", uif.getMemberName());
		hs.setAttribute("nick", uif.getMemberEmail());
		
		
		if (uif.getMemberName()!=null) {
			response.sendRedirect("paging");
		}else {
			hs.invalidate();
			response.sendRedirect("lion.html");		
		}
		
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
