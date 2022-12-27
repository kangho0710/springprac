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
<form action="/shop-list">
		<input type = "text" name = "siName" placeholder = "상품이름">
		<input type = "text" name = "siCategory" placeholder = "카테고리">
		<input type = "text" name = "siSupplier" placeholder = "유통사">
		<button>조회</button>
	</form>
	<button onclick="location.href='/views/shop-info/shopinsert'">추가하기</button>
	
	<table border="1">
		<tr>
			<th>코드</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>유통사</th>
			<th>가격</th>
		</tr>

		<c:forEach items="${shopList }" var="shop">
			<tr>
				<td>${shop.siCode }</td>
				<td>${shop.siName }</td>
				<td>${shop.siCategory }</td>
				<td>${shop.siSupplier }</td>
				<td>${shop.siPrice }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>