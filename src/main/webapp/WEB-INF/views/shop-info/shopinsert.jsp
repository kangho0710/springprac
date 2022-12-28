<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action = "/shop-infos/insert">
		<input type="text" name="siCode" placeholder="코드">
		<input type="text" name="siName" placeholder="제목">
		<input type="text" name="siCategory" placeholder="카테고리">
		<br>
		<input type="text" name="siStock" placeholder="재고">
		<input type="text" name="siSupplier" placeholder="유통">
		<input type="text" name="siPrice" placeholder="가격">
		<br>
		<textarea name="siEtc" rows="5" cols="40" placeholder="내용"></textarea>

		<button>작성</button>
	</form>
</body>
</html>