<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/board-info/select">
		<input readonly type="text"  name="biTitle" placeholder="제목" value = "${boardInfo.biTitle }">
		 <input readonly type="text" name="biWriter" placeholder="작성자" value = "${boardInfo.biWriter }"> <br>
		<textarea readonly name="biContent" rows="5" cols="40" placeholder="내용">"${boardInfo.biContent }"
		</textarea>
	</form>
	
<button onclick = "location.href= '/board-info/update?biNum=${boardInfo.biNum}'">수정하러가기</button>
	
</body>
</html>