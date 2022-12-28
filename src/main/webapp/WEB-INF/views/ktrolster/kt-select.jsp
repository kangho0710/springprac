<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="Get" action="/kt-list/select">
		<input readonly type="text"  name="ktName" placeholder="이름" value = "${kt.ktName }">
		 <input readonly type="text" name="ktId" placeholder="id" value = "${kt.ktId }"> 
		 <input readonly type="text" name="ktAge" placeholder="나이" value = "${kt.ktAge }">
		<input readonly type="text" name="ktKda" placeholder="kda" value = "${kt.ktKda  }"><br>
		<textarea readonly name="ktProfile" rows="5" cols="40" placeholder="프로필">"${kt.ktProfile }"
		</textarea>
	</form>
	<button onclick = "location.href= '/kt-list/update?ktNum=${kt.ktNum}'" >수정</button>
</body>
</html>