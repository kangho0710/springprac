<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ="1">
		<tr>
			<th>제목</th>
			<td><input type = "text" id = "boardTitle"></td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td><input type = "text" id = "boardWriter"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="40" id = "boardContent"></textarea></td>
		</tr>
		<tr>
			<th colspan = "2">
				<button onclick = "updateBoard()">수정</button>
			</th>
		</tr>
	</table>
	
	<script>
		window.onload = function(){
			fetch('/board/${param.boardNo}')
			.then(function(res){
				return res.json();
			})
			.then(function(board){
				console.log(board)
				document.querySelector('#boardTitle').value = board.boardTitle;
				document.querySelector('#boardWriter').value = board.boardWriter;
				document.querySelector('#boardContent').value = board.boardContent;
			});
		}
		function updateBoard() {
			const param = {};
			param.boardTitle = document.querySelector('#boardTitle').value;
			param.boardWriter = document.querySelector('#boardWriter').value;
			param.boardContent = document.querySelector('#boardContent').value;
			
			fetch('/board-update/${param.boardNo}', {
				method : 'PATCH',
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
			}).then(function(res) {
				return res.json();
			}).then(function(data) {
				if (data === 1) {
					alert('수정완료');
					location.href = '/views/board/list';
				}
			});
		}
	</script>
</body>
</html>