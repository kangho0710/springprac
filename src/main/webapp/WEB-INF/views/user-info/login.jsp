<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="uiId" placeholder="id"><br>
	<input type="password" id="uiPwd" placeholder="pwd"><br>
	<button onclick = "login()">로그인</button>
	
	<script>
	function login(){
		let param = {
			uiId : document.querySelector('#uiId').value,
			uiPwd : document.querySelector('#uiPwd').value
		}
		
		fetch('/login',{
			method:'POST',
			headers:{
				'Content-Type':'application/json'
			},
			body:JSON.stringify(param)
		})
		.then(function(res){
			return res.text() //null이면 json으로 안되서 한번 text로 까봄
		})
		.then(function(data){
			if(data ){
				data = JSON.parse(data); //다시 파싱
				if(data.uiName){
				 alert(data.uiName + '님 로그인 완료!');
				 location.href='/';
				 return;
				}
			}
			alert('아이디 비번을 확인해주세요.');
		})
	}
	</script>
</body>
</html>