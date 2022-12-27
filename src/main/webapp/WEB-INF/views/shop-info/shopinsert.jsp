<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" name="${shop.siCode } " placeholder="코드">
	<input type="text" name="${shop.siName }" placeholder="제목">
	<input type="text" name="${shop.siCategory }" placeholder="카테고리">
	<br>
	<input type="text" name="${shop.siStock }" placeholder="재고">
	<input type="text" name="${shop.siSupplier }" placeholder="유통">
	<input type="text" name="${shop.siPrice }" placeholder="가격">
	<br>
	<textarea name="${shop.siEtc }" rows="5" cols="40" placeholder="내용"></textarea>

	<form method="POST" action = "/shop-insert">
		<button>작성</button>
	</form>
</body>
</html>