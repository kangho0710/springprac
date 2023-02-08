<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="rDiv"></div>
	<div>
		<button onclick = "location.href = '/views/board/update?boardNo=${param.boardNo}'">수정</button>
		<button onclick = "deleteBoard()">삭제</button>
	</div>
	
		<script>
		window.onload = function(){
			fetch('/board/${param.boardNo}')
			.then(function(res){
				return res.json();
			})
			.then(function(board){
				console.log(board)
				let html = '';
				html += '번호 :' + board.boardNo + '<br>';
				html += '제목 :' + board.boardTitle + '<br>';
				html += '작성자 :' + board.boardWriter + '<br>';
				html += '내용 :' + board.boardContent + '<br>';
				document.querySelector('#rDiv').innerHTML = html;
			});
		}
		
		function deleteBoard(){
			fetch('/board-delete/${param.boardNo}',{
				method:'DELETE'
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data===1){
					alert('삭제완료');
					location.href = '/views/board/list';
				}
			});
		}
		
		
	</script>
</body>
</html>