<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/kt-list/insert">
		<input type="text"  name="ktName" placeholder="이름" value = "${ktName}">
		 <input type="text" name="ktId" placeholder="id" value = "${ktId}"> 
		 <input type="text" name="ktAge" placeholder="나이" value = "${ktAge}">
		<input type="text" name="ktKda" placeholder="kda" value = "${ktKda}"><br>
		<textarea name="ktProfile" rows="5" cols="40" placeholder="프로필">"${ktProfile}"
		</textarea>
		<button>등록</button>
	</form>

</body>
</html>