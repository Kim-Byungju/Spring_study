<%@page import="com.mycompany.biz.board.impl.BoardDAOSpring"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.mycompany.biz.board.impl.BoardDAO"%> --%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=utf-8"%>

<!-- JSTL활용 -->
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"  %>

<%
//	List<BoardVO> boardList = (List) session.getAttribute("boardList");	
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>글 목록</title>
<style type="text/css">
	th{background-color: lightgaray}	
	div{text-align: center;}
	table{ margin:50px auto; text-align:center; border: 1px solid black}
	input{border-width: 0}
</style>
</head>
<body>
	<div>
		<h1>글 목록</h1>
		<h3>
			테스트님 환영합니다...<a href="logout.do">로그아웃</a>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
								<option value="TITLE">제목
								<option value="CONTENT">내용
						</select> 
						<input name="searchKeyword" type="text" /> 
						<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">내용</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
	<%-- 		
			<%
				for (BoardVO board : boardList) {
			%>
			<tr>
				<td><%=board.getSeq()%></td>
				
				<td align="left"><a href="getBoard.jsp?seq=<%=board.getSeq()%>">
						<%=board.getTitle()%></a></td>
						
				<td align="left"><a href="getBoard.do?seq=<%=board.getSeq()%>"> 
						<%=board.getTitle()%></a></td>		
				<td><%=board.getWriter()%></td>
				<td><%=board.getRegDate()%></td>
				<td><%=board.getCnt()%></td>
			</tr>
			<%
				}
			%>
	--%>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<%-- <td>${board.seq}</td> --%>
					<td>${board.seq}</td>
					<td align="center">
						<a href="getBoard.do?seq=${board.seq}">
							${board.title}
						</a>
					</td>
					<td>${board.writer}</td>
					<td>${board.content }
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>			
			</c:forEach>
			
		</table>
		<br> <a href="insertBoard.jsp">새글 등록</a>
	</div>
</body>
</html>