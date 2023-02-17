package com.greedy.section01.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("redirect 페이지의 session id : "+session.getId());
		
		/*세션안에 담긴 모든 attribute의 키 목록 반환 */
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		/* 동일한 아이디를 가진 세션에서는 setAttribute한 값을 getAttribute로 꺼내올수 있다.
		 * */
		String firstName = (String)session.getAttribute("firstName");
		String lastName = (String)session.getAttribute("lastName");
		
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
				.append("<html>\n")
				.append("<head>\n")
				.append("</head>\n")
				.append("<body>\n")
				.append("<h1 align='center'>")
				.append("Your firstname is '")
				.append(firstName)
				.append("' and lastname is  '")
				.append(lastName+"'")
				.append("</h1>\n")
				.append("</body>\n")
				.append("</html>");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());
		out.flush();
		out.close();
		
		
	}
	


}
