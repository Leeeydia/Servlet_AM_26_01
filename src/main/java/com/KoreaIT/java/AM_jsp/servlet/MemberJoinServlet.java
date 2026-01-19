package com.KoreaIT.java.AM_jsp.servlet;

import java.io.IOException;
@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);
	}

}