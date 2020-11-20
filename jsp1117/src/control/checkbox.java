package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkbox")
public class checkbox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public checkbox() {
		super();

	}
	
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkboxresult.jsp");
		
		String image[] = request.getParameterValues("pick");
				
		request.setAttribute("images", image);

		dispatcher.forward(request, response);

		//		PrintWriter out = response.getWriter();

		//		out.println("<html>");
		//		out.println("<head>");
		//		out.println("<title>이미지선택page</title>");
		//		out.println("<style>");
		//		out.println("body{ background-color : orange;}");
		//		out.println("table{ background-color : yellow;}");
		//		out.println("</style>");
		//		out.println("</head>");
		//		out.println("<body>");
		//		out.println("<table>");		
		//		out.println("<tr>");

		//		for (int i = 0; i < image.length; i++) {
		//			out.println("<td>");
		//			out.println("<img src = 'image/" +image[i] + "'width='200px' height='200px'>");
		//			out.println("</td>");
		//		}

		//		out.println("</tr>");
		//		out.println("</table>");
		//		out.println("</body>");
		//		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doprocess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doprocess(request, response);

	}

}