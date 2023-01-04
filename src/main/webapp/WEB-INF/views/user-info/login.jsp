<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<input type = "text" id = "uiId" placeholder = "id"><br>
	<input type = "password" id = "uiPwd" placeholder = "비밀번호"><br>
	<button onclick = "login()">로그인</button>
	
	<script>
		function login(){
			const param = {
				uiId : document.querySelector('#uiId').value,
				uiPwd : document.querySelector('#uiPwd').value
			}
			fetch('/user-infos/login',{
				method : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
			})
			.then(function(res){
				return res.text();
			})
			.then(function(data){
				if(data){
					data = JSON.parse(data);
					if(data.uiName){
						alert(data.uiName + '님 ㅎㅇ');
						location.href = '/';
						return;
					}
				}
				else{
					alert('아이디와 비밀번호 확인');
				}
			});
		}
	</script>
</body>
</html>