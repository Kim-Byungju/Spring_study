<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@page import="com.mycompany.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO boardDAO = new BoardDAO();
	BoardVO boardVO = new BoardVO();
	ArrayList<BoardVO> boardList = (ArrayList<BoardVO>)session.getAttribute("boardList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	th{
		background: lightgray;
	}
	div {
	text-align: center;
}
</style>

</head>
<body>
	<div align="center">
		<h1>글 목록</h1>
		<h3>테스트님 환영합니다.....<a href="logout.do">로그아웃</a></h3>
		<form action="getBoardList.do" method="post">
			<table border="1" align="center">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
						</select>
						<input name="searchkeyword" type="text">&nbsp;
						<input name="" type="submit" value="검색">
					</td>
				</tr>
			</table>
		</form>
		<table border="1" width="700px" align="center">
			<tr>
				<th width="100">번호</th>
				<th width="250">제목</th>
				<th width="100">작성자</th>				
				<th width="150">등록일</th>				
				<th width="100">조회수</th>				
			</tr>
			<% for(BoardVO board : boardList) {%>
			<tr>
				<td><%=board.getSeq() %></td>
				<td><a href="getBoard.do?seq=<%= board.getSeq() %>"><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getRegDate() %></td>
				<td><%=board.getCnt() %></td>
			</tr>
			<%
				}
			%>
		</table><br>
		<a href="insertBoard.jsp">새글등록</a>
	</div>
</body>
</html>