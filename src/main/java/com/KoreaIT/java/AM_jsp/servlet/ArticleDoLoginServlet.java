package com.KoreaIT.java.AM_jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.util.DBUtil;
import com.KoreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class ArticleDoLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/Servlet_AM_26_01?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);

			String loginId = request.getParameter("LoginId");
			String loginPw = request.getParameter("LoginPw");

			SecSql sql = SecSql.from("SELECT * FROM `member`");
			sql.append("WHERE loginId = ?", loginId);

			Map<String, Object> member = DBUtil.selectRow(conn, sql);

			if (member.isEmpty()) {
				response.getWriter().append("""
							<script>
								alert('존재하지 않는 아이디입니다.');
								history.back();
							</script>
						""");
				return;
			}

			if (!member.get("loginPw").equals(loginPw)) {
				response.getWriter().append("""
							<script>
								alert('비밀번호가 틀렸습니다.');
								history.back();
							</script>
						""");
				return;
			}

			response.getWriter().append("""
						<script>
							alert('로그인 성공');
							location.replace('/home/main');
						</script>
					""");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
