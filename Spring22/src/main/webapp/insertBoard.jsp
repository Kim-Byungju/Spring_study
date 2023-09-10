<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{ margin:50px auto; text-align:center; border: 1px solid black}
	input{border-width: 0}
</style>
</head>
<body>
	<div>
		<h1>글 등록</h1>
		<a href="logout.do">로그아웃</a>
		<hr>
		<!-- 
			enctype
				. multipart/form-data : 파일 업로드 <input type = "file">를 포함한 이진데이터를 전송할때
				. application/x-www-form-urlcencoded : 그 외. 디폴트 
				. text/plain : 인코딩없이 전송, 보안성이 없다. 디버깅으로 사용
		 -->
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td bgcolor="lightgray" width="70px">제목</td>
					<td align="left"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >작성자</td>
					<td align="left"><input type="text" name="writer" size="10"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >내용</td>
					<td align="left"><textarea name="content" cols="40" row="10"></textarea></td>
				</tr>
				<tr>
					<td bgcolor="lightgray">업로드</td>
					<td>
						<input type="file" name="uploadFile">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" ><input type="submit" value="새글등록"></td>
				</tr>
			</table>		
		</form>
		<hr>
		<a href="getBoardList.do">글 목록가기</a>
	</div>
</body>
</html>