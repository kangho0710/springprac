<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="POST" action="/kt-list/update">
		<input type="hidden"  name="ktNum" placeholder="번호" value = "${kt.ktNum }">
		<input type="text"  name="ktName" placeholder="이름" value = "${kt.ktName }">
		 <input type="text" name="ktId" placeholder="id" value = "${kt.ktId }"> 
		 <input type="text" name="ktAge" placeholder="나이" value = "${kt.ktAge }">
		<input type="text" name="ktKda" placeholder="kda" value = "${kt.ktKda  }"><br>
		<textarea name="ktProfile" rows="5" cols="40" placeholder="프로필">"${kt.ktProfile }"
		</textarea>
		<button>수정</button>
		<button formaction = "/kt-list/delete">삭제</button>
	</form>

</body>
</html>