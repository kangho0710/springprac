<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type = "text" id = "uiId" value = "${userInfo.uiId}" disabled><br>
	<input type = "text" id = "uiEmail" value = "${userInfo.uiId}" placeholder = "이메일"><br>
	<input type = "text" id = "uiZip" value = "${userInfo.uiId}" placeholder = "우편번호" disabled><button onclick="searchAddr()">검색</button><br>
	<input type = "text" id = "uiAddr1" value = "${userInfo.uiId}" placeholder = "주소" disabled><br>
	<input type = "text" id = "uiAddr2" value = "${userInfo.uiId}" placeholder = "상세주소"><br>
	<input type = "text" id = "uiProfile" value = "${userInfo.uiId}" placeholder = "프로필"><br>

<script>
function join(){
	const ui = getParams();
	
	fetch('/user-infos/${userInfo.uiNum}',{
		method : 'PATCH',
		headers :{
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(ui)
	})
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		if(data===1){
			alert('회원가입 성공');
			location.href = '/views/user-info/login';
		}
	});
	
	
}
</script>
</body>
</html>