package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import services.MemberIdCheckService;


@WebServlet("/memberIdCheck")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberIdCheck() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int result = 0;
		System.out.println(id);

		String Url = request.getRequestURL().toString();
		System.out.println("URL : " + Url);
		MemberIdCheckService mis = new MemberIdCheckService();
		result = mis.membeIdCheck(id);

		
		JSONObject obj = new JSONObject();
		
		obj.put("cnt",result);
		System.out.println(obj);
		String data = obj.toString();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(data);	

	}

}
