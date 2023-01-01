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
		<h2>성적 조회</h2>
		<table class="table">
			<tr>
				<th scope="col">번호</th>
				<td data-col="spNum"></td>
			</tr>
			<tr>
				<th scope="col">이름</th>
				<td data-col="spName"></td>
			</tr>
			<tr>
				<th scope="col">국어</th>
				<td data-col="spKorPoint"></td>
			</tr>
			<tr>
				<th scope="col">영어</th>
				<td data-col="spEngPoint"></td>
			</tr>
			<tr>
				<th scope="col">수학</th>
				<td data-col="spMathPoint"></td>
			</tr>
			<tr>
				<th scope="col">프로필</th>
				<td data-col="spProfile"></td>
			</tr>
		</table>
		<button class="btn btn-primary" onclick="location.href='/views/student-point/update?spNum=${param.spNum}'">수정</button>
		<button class="btn btn-primary"
			onclick='history.back()'>돌아가기</button>
	</div>



<script>
	window.onload= function(){
		const spNum = '${param.spNum}';
		alert(spNum);
		
		fetch('/student-points/view?spNum='+spNum)
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			let html = '';
			const tdObjs = document.querySelectorAll('td[data-col]');
			for(const tdObj of tdObjs){
				tdObj.innerHTML = data[tdObj.getAttribute('data-col')];
			}
		});
	}
</script>
</body>
</html>