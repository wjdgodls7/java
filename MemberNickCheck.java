package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import services.MemberIdCheckService;
import services.MemberNickCheckService;


@WebServlet("/membernickCheck")
public class MemberNickCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberNickCheck() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		int result = 0;


		String Url = request.getRequestURL().toString();
		System.out.println("URL : " + Url);
		MemberNickCheckService mns = new MemberNickCheckService();
		result = mns.MembeNickCheckService(nick);


		JSONObject obj = new JSONObject();

		obj.put("cnt",result);
		String data = obj.toString();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(data);	

	}
}
