<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/board-infos/update">
	<input type="hidden"  name="biNum" placeholder="번호" value = "${boardInfo.biNum}">
		<input type="text"  name="biTitle" placeholder="제목" value = "${boardInfo.biTitle }">
		 <input  type="text" name="biWriter" placeholder="작성자" value = "${boardInfo.biWriter }"> <br>
		<textarea  name="biContent" rows="5" cols="40" placeholder="내용">"${boardInfo.biContent }"
		</textarea>
		<button>수정</button>
		<button formaction = "/board-info/delete">삭제</button>
	</form>
</body>
</html>