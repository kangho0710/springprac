<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<table class="table">
			<tr>
				<th scope="col">번호</th>
				<td data-col="soNum"></td>
			</tr>
			<tr>
				<th scope="col">제목</th>
				<td data-col="soTitle"></td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td data-col="soId"></td>
			</tr>
			<tr>
				<th scope="col">팀</th>
				<td data-col="soTeam"></td>
			</tr>
			<tr>
				<th scope="col">내용</th>
				<td data-col="soContent"></td>
			</tr>
		</table>
		<button class="btn btn-primary" onclick="location.href='/views/soccergallery/update?soNum=${param.soNum}'">수정</button>
		<button class="btn btn-primary"
			onclick='history.back()'>돌아가기</button>
	</div>
<script>
	window.onload = function(){
		const soNum = '${param.soNum}';
		
		fetch('/soccergallery/select?soNum='+soNum)
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			let html = '';
			const tdObjs = document.querySelectorAll('td[data-col]');
			for(const tdObj of tdObjs){
				tdObj.innerHTML = data[tdObj.getAttribute('data-col')];
			}
		})
	}
</script>
</body>
</html>