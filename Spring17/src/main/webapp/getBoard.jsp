<%@page import="com.mycompany.biz.board.impl.BoardDAO"%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardVO board = (BoardVO)session.getAttribute("board");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>글 상세</h1>
		<a href="logout.do">로그아웃</a>
		<hr>
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="<%=board.getSeq()%>">
			<table border="1">
				<tr>
					<td bgcolor="lightgray" width="70px">제목</td>
					<td align="left"><input type="text" name="title" value="<%=board.getTitle()%>"></td>
				</tr>			
				<tr>
					<td bgcolor="lightgray" >작성자</td>
					<td align="left"><input type="text" name="writer" value="<%=board.getWriter()%>"></td>
				</tr>			
				<tr>
					<td bgcolor="lightgray" >내용</td>
					<td align="left"><textarea name="content" cols="40" row="10"><%=board.getContent()%></textarea></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >등록일</td>
					<td align="left"><%=board.getRegDate() %></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >조회수</td>
					<td align="left"><%=board.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="글수정"></td>
				</tr>				
				
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=<%= board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글 목록</a>
	</div>
</body>
</html>