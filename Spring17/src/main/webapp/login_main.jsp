<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<hr>
		<form action="login.do" method="get">
			<table border="1" cellpadding="0" cellspacing="0" >
				<tr>
					<td bgcolor="lightgray">아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray">비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>