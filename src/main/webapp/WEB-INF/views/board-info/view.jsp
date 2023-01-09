<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "rDiv"></div>
	<div id = "btnDiv" style="display:none">
		<button onclick = "location.href = '/views/board-info/update?biNum=${param.biNum}'">수정</button>
		<button onclick = "deleteBoardInfo()">삭제</button>
	</div>
	
	
	<script>
		window.onload = function(){
			fetch('/board-infos/${param.biNum}')
			.then(function(res){
				return res.json();
			})
			.then(function(boardInfo){
				console.log(boardInfo)
				let html = '';
				html += '번호 :' + boardInfo.biNum + '<br>';
				html += '제목 :' + boardInfo.biTitle + '<br>';
				html += '작성자 :' + boardInfo.uiId + '<br>';
				html += '내용 :' + boardInfo.biContent + '<br>';
				document.querySelector('#rDiv').innerHTML = html;
				
				if(boardInfo.uiNum =='${userInfo.uiNum}'){
					document.querySelector('#btnDiv').style.display='';
				}
			});
		}
		
		function deleteBoardInfo(){
			const spNum = '${param.biNum}'
			fetch('/board-infos/${param.biNum}',{
				method:'DELETE'
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data===1){
					alert('삭제완료');
					location.href = '/views/board-info/list';
				}
			});
		}
		
		
	</script>
	
</body>
</html>