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
			<th><input type = "checkbox" name="allCheck" onclick="toggleCheck(this)"></th>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>팀</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
		<tbody id = "tBody">
		</tbody>
	</table>
	<button onclick = "location.href = '/views/soccergallery/insert'">등록</button>
	<button onclick = "deleteStudentPoints()">삭제</button>
	
	<script>
		function getSoccerGalleryList(){
			fetch('/soccergallery')
			.then(function(res){
				return res.json()
			})
			.then(function(data){
				let html = '';
				for(let i = 0; i<data.length; i++){
					const soccerGallery = data[i];
					html += '<tr>'
					html += '<td><input type="checkbox" name = "soNums" value="'+ soccerGallery.soNum + '"></td>'
					html += '<td><a href = "/views/soccergallery/select?soNum=' + soccerGallery.soNum + '"></td>'
					html += '</tr>'
				}
			})
		}
	</script>

</body>
</html>