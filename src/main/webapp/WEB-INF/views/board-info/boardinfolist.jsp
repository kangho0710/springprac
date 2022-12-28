<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/board-info">
		<input type = "text" name = "biTitle" value="${param.biTitle}"  placeholder = "제목">
		<input type = "text" name = "biWriter" value="${param.biWriter}" placeholder = "작성자">
		<button>조회</button>
	</form>
	
	<table border = "1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach items = "${boardList }" var = "board">
			<tr style="cursor:pointer" onclick="location.href= '/board-info/select?biNum=${board.biNum}'">
				<th>${board.biNum}</th>
				<th>${board.biWriter}</th>
				<th>${board.biTitle}</th>
				<th>${board.biCnt}</th>
				<th>${board.credat}</th>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="location.href='/views/board-info/boardinsert'">등록</button>
</body>
</html>