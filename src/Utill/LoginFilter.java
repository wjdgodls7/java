package Utill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	private List<String> whiteList;
	private List<String> resourceList;
	
    public LoginFilter() {
       whiteList = new ArrayList<String>();
       whiteList.add("/index.html");
       whiteList.add("/JoinForm.jsp");
       whiteList.add("/memberLogin");
       whiteList.add("/memberJoin");
       whiteList.add("/memberIdCheck");
       whiteList.add("/membernickCheck");
       whiteList.add("/about.jsp");

       resourceList = new ArrayList<String>();
       resourceList.add("/5thBoard/assets/css/");
       resourceList.add("/5thBoard/assets/img/");
       resourceList.add("/5thBoard/assets/js/");
       resourceList.add("/5thBoard/assets/vendor/");
  
    }

	public void destroy() {
		// 초기화를 담당하며 가장 마지막에 실행이 된다.
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 주요 기능이 들어가고 설정을 해주면 모든 URL의 접근이 반드시 거쳐야 하는 곳
		// 여기서 LOGIN 상태 비교 기능 구현 !
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		boolean isResource = false;
		boolean flag = true;
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		for(int i = 0; i<whiteList.size(); i++) {
			if(uri.contains(whiteList.get(i))) {
				flag = false;
			}
		}
		for (String i : resourceList) {
			if(uri.startsWith(i)) {
				isResource = true;
				break;
			}
		}
		
		if(!isResource) {
			if(flag) {
				String id = (String)session.getAttribute("id");
				if(id==null) {
					RequestDispatcher rd = req.getRequestDispatcher("alert.jsp");
					req.setAttribute("value", "로그인이 필요합니다.");
					rd.forward(request, response);
				}
			}
		}
		
		chain.doFilter(request, response);
	}


//	public void init(FilterConfig fConfig) throws ServletException {
//		// 가장 처음 실행이 되며 단 한번 실행이 된다.
//		// 서버가 완전히 실행되기전에 실행 되므로 웹에 먼저 불러와야 할 자료들이 있거나 쓰면 좋다.
//	}

}
