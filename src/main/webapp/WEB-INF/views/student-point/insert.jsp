<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/import.jsp"%>
</head>
<body>
	<input type = "text" id="spName" placeholder = "이름">
	<input type = "text" id="spKorPoint" placeholder = "국어">
	<input type = "text" id="spEngPoint" placeholder = "영어">
	<input type = "text" id="spMathPoint" placeholder = "수학"><br>
	<input type = "text" id="spProfile" placeholder = "프로필"><br>
	
	<button onclick = 'insertStudentPoint()'>등록</button>
	<script>
	function insertStudentPoint(){
		const sp = getParams();
		fetch('/student-points',{
			method:'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(sp)
		})
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			if(data==1){
				alert('성공');
			}
		});
	}
	</script>
</body>
</html>