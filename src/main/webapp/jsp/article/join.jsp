<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");

int cPage = (int) request.getAttribute("page");
int totalCnt = (int) request.getAttribute("totalCnt");
int totalPage = (int) request.getAttribute("totalPage");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="../home/main">메인으로 이동</a>
	<h3>회원가입</h3>
	<form action="/main/Join" method="post"> 
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>PWD</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>가입</th>
				<td><input type="submit" value="가입"></td>
			</tr>

		</table>
	</form>
</body>
</html>