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
	<input type = "text" id="soId" placeholder = "작성자">
	<input type = "text" id="soTitle" placeholder = "제목">
	<input type = "text" id="soTeam" placeholder = "팀"><br>
	<input type = "text" id="soContent" placeholder = "내용">
	
	<button onclick = 'insertSoccerGallery()'>등록</button>
	
	<script>
		function insertSoccerGallery(){
			const so = getParams();
			fetch('/soccergallery/insert',{
				method:'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(so)
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data==1){
					alert('성공');
					location.href = '/views/soccergallery/list';
				}
			});
		}
	</script>

</body>
</html>