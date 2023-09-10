<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" bgcolor="orange">오류페이지 입니다.</td>
		</tr>
	</table>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
		<tr>
			
			<td>
				<br><br><br>
				Message: ${exception.message }
				<br><br><br>
			</td>
			
		</tr>
	</table>
</body>
</html>