<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type = "text" id = "uiId" placeholder = "id">
	<input type = "password" id = "uiPwd" placeholder = "password">
	<br>
	<button onclick = "login()">로그인</button>
	
	<script>
		function login(){
			let param = {
				uiId = document.querySelector('#uiId').value,
				uiPwd = document.querySelector('#uiPwd').value
			}
			fetch('/login',{
				method: 'POST',
				headers:{
					'ContentType': 'application/json'
				},
				body:JSON.stringify(param);
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data &&)
			})
		}
	</script>
</body>
</html>