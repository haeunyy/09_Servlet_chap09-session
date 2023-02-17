package com.greedy.section01.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : "+ firstName);
		System.out.println("lastName : "+ lastName);
		
		/* Session객체를 사용해보자 
		 * 쿠키는 클라이언트 컴퓨터에 저장되므로 민감한 정보를 담기에는 적합하지 않다. 
		 * 서버쪽에서 관리되는 세션이라는 인스턴스를 사용해보자 */
		HttpSession session = request.getSession();
		
		/* 세션은 강제로 만료 시키는 기능도 있지만 만료 시간을 설정해주는 것이 좋다. 
		 * 기본 설정 시간은 30분이며 필요에 따라 늘이거나 줄이면 된다. */
		System.out.println("session default 유지 시간 : "+ session.getMaxInactiveInterval());
		session.setMaxInactiveInterval(60*10); // 10분으로 설정
		System.out.println("session 변경 후 유지 시간 : "+ session.getMaxInactiveInterval());
		// 모든 브라우저 창을 닫아야 세션시간을 확인가능
		
		/* 세션은 브라우저 당 한 개씩 고유한 아이디를 가지고 하나의 인스턴스를 이용한다. 
		 * 매번 반복적인 요청을 할 경우 동일한 session id를 리턴한다. */
		System.out.println("session id : "+ session.getId());
		
		/* 세션은 redirect를 해도 값을 유지할 수 있는 request 보다 더 넓은 범위의 공유영역이라고 표현할 수 있다. */
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		
		response.sendRedirect("redirect");
	}

}
