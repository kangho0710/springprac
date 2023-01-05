<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<input type = "text" id = "biTitle" placeholder = "제목">
		<input type = "text" id = "biContent" placeholder = "내용">
		<button onclick = "getBoardLists()">조회</button>
	
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
	
	<button onclick="location.href='/views/board-info/insert'">등록</button>
	
	<script>
	function getBoardLists(){
		let param = '?biTitle=' + document.querySelector('#biTitle').value;
		param += '&biContent=' + document.querySelector('#biContent').value;
		
		fetch('/board-infos'+param)
		.then(function(res){
			return res.json();
		}).then(function(data){
			let html = '';
			for(let i = 0; i<data.length; i++){
				const boardList =data[i];
				html += '<tr>' ;
				html +='<td>' + boardList.biNum + '</td>';
				html +='<td>' + boardList.uiId + '</td>';
				html += '<td><a href="/views/board-info/view?biNum=' + boardList.biNum + '">' + boardList.biTitle + '</a></td>';
				html +='<td>' + boardList.biCnt + '</td>';
				html +='<td>' + boardList.biCredat + '</td>';
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