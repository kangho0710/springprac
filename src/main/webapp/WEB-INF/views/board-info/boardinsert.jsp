<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/board-info/insert">
	<table border="1">
		<tr>
			<th><input type="text"  name="biTitle" placeholder="제목" value = "${boardInfo.biTitle }"></th>
		 	<th><input type="text" name="biWriter" placeholder="작성자" value = "${boardInfo.biWriter }"></th>
		</tr>
		<tr>
			<td>
			<textarea name="biContent" rows="5" cols="40" placeholder="내용">"${boardInfo.biContent }"
			</textarea></td>
		</tr>
	</table>
		<button>작성</button>
	</form>
</body>
</html>