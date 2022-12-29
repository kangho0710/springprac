<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type = "hidden" readonly id = "tiNum" placeholder = "번호">
	<input type = "text" readonly id = "tiName" placeholder = "이름">
	<input type = "text" readonly id = "tiAge" placeholder = "나이">
	<input type = "text" readonly id = "tiAddress" placeholder = "주소">
	
	<script>
		function getTestInfo(){
			fetch('/test-info/select?tiNum='+document.querySelector('#tiNum').value)
			.then(function test(){
				return test.json();
			})
			.then(function data(){
				
			});
		}
	</script>
</body>
</html>