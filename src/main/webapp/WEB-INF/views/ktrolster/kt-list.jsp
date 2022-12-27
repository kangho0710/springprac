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
	<form action="/kt-list">
		<input type = "text" name = "ktName" placeholder = "이름">
		<input type = "text" name = "ktId" placeholder = "닉네임">
		<button>조회</button>
	</form>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>닉네임</th>
			<th>나이</th>
			<th>kda</th>
			<th>프로필</th>
		</tr>

		<c:forEach items="${ktList }" var="kt">
			<tr>
				<td>${kt.ktName }</td>
				<td>${kt.ktId }</td>
				<td>${kt.ktAge }</td>
				<td>${kt.ktKda }</td>
				<td>${kt.ktProfile }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>