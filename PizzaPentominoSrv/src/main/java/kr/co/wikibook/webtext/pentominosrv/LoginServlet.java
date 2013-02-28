/**
 * Copyright 2009 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentominosrv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 로그인 처리를 위한 서블릿<br />
 * 
 * @author y-komori
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 9047808489131685958L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
@Override
protected void doPost(final HttpServletRequest request,
		final HttpServletResponse responce) throws ServletException,
		IOException {
	// 요청 매개변수로부터 입력된 패스워드를 꺼낸다
	String password = request.getParameter("password");

	String nextJsp;
	if ("webtext".equals(password)) {
		// 패스워드가 정확할 경우
		// 아이디를 요청에 저장한다
		String user = request.getParameter("user");
		request.setAttribute("user", user);

		// 상품 목록 화면으로 이동한다
		nextJsp = "/itemList.jsp";
	} else {
		// 패스워드가 틀렸으면 로그인 실패 페이지로 이동한다
		nextJsp = "/loginFailed.jsp";
	}

	// 이동할 곳의 JSP로 포워드
	RequestDispatcher dispatcher = request.getRequestDispatcher(nextJsp);
	dispatcher.forward(request, responce);
}
}
