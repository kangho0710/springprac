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
	<input type = "number" readonly id="soNum" placeholder = "번호"><br>
	<input type = "text" readonly id="soId" placeholder = "작성자">
	<input type = "text" id="soTitle" placeholder = "제목">
	<input type = "text" id="soContent" placeholder = "내용">
	<input type = "text" id="soTeam" placeholder = "팀"><br>
	
	<button onclick = 'updateSoccerGallery()'>수정</button>
	<button onclick = 'deleteSoccerGallery()'>삭제</button>
	<button onclick = 'history.back()'>돌아가기</button>
	
	<script>
		window.onload = function(){
			const soNum = '${param.soNum}';
			
			fetch('/soccergallery/select?soNum='+soNum)
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				let html = '';
				const tdObjs = document.querySelectorAll('input[id]');
				for(const tdObj of tdObjs){
					tdObj.value = data[tdObj.getAttribute('id')];
				}
			});
		}
		
		function updateSoccerGallery(){
			const soNum = '${param.soNum}'
			const so = getParams();
			
			fetch('/soccergallery/update/'+soNum,{
				method:'PATCH',
				headers:{
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
		
		function deleteSoccerGallery(){
			const soNum = '${param.soNum}'
			
			fetch('/soccergallery/delete/'+soNum,{
				method:'DELETE',
				headers:{
					'Content-Type': 'application/json'
				},
				
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