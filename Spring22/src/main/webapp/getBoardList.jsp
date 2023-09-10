<%@page import="com.mycompany.biz.board.impl.BoardDAOSpring"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.mycompany.biz.board.impl.BoardDAO"%> --%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=utf-8"%>

<!-- JSTL활용 -->
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="message.board.list.mainTitle"/></title>
<style type="text/css">
	th{background-color: lightgaray}	
	div{text-align: center;}
	table{ margin:50px auto; text-align:center; border: 1px solid black}
	input{border-width: 0}
</style>
</head>
<body>
	<div>
		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<h3>
			${sessionScope.username }<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do"> <spring:message code="message.user.login.logoutBtn"/></a>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<c:forEach items="${conditionMap }" var="option">
								<option value="${option.value}">${option.key}
							</c:forEach>
						</select> 
						<input name="searchKeyword" type="text" /> 
						<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>" />
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
				<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.content"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
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
		<br> <a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
	</div>
</body>
</html>