<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<tbody id=tBody></tbody>
	</table>
	
	<button onclick="location.href='/views/board/insert'">등록</button>
	<script>
	function getBoardLists(){
		
		fetch('/board-list')
		.then(function(res){
			return res.json();
		}).then(function(data){
			let html = '';
			for(let i = 0; i<data.length; i++){
				const boardList =data[i];
				html += '<tr>' ;
				html +='<td>' + boardList.boardNo + '</td>';
				html +='<td>' + boardList.boardWriter + '</td>';
				html += '<td><a href="/views/board/view?boardNo=' + boardList.boardNo + '">' + boardList.boardTitle + '</a></td>';
				html +='<td>' + boardList.boardCredat + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		})
	}
		window.onload = function(){
			getBoardLists();
		}
  </script>
	
</body>
</html>