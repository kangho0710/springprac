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
	
		function deleteStudentPoints(){
			const soNumObjs = document.querySelectorAll('input[name="soNums"]:checked');
			const soNums = [];
			for(const soNumObj of soNumObjs){
				soNums.push(soNumObj.value);
			}
			
			if(soNums.length ===0){
				alert('선택바람');
				return;
			}
			
			const param = {
					soNums:soNums
			}
			fetch('/soccergallery/deletes',{
				method: 'DELETE',
				headers: {
					 'Content-Type': 'application/json'
				},
				body: JSON.stringify(param)
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data>=1){
					alert('성공');
					location.href='/views/soccergallery/list';
				}
			})
		} //체크된거 삭제
		
		function toggleCheck(obj){
			const soNums = document.querySelectorAll('input[name=soNums]');
			for(const soNum of soNums){
				soNum.checked = obj.checked;
			}
		} //체크박스
		
		
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
					html += '<td>' + soccerGallery.soNum + '</td>';
					html += '<td><a href = "/views/soccergallery/select?soNum=' + soccerGallery.soNum + '">'+soccerGallery.soTitle+'</td>'
					html += '<td>' +soccerGallery.soId + '</td>';
					html += '<td>' +soccerGallery.soTeam + '</td>';
					html += '<td>' +soccerGallery.soCnt + '</td>';
					html += '<td>' +soccerGallery.moddat + '</td>';
					html += '</tr>'
				}
				document.querySelector('#tBody').innerHTML = html;
			});
			
		}
			window.onload = function(){
				getSoccerGalleryList();
			}
	</script>

</body>
</html>