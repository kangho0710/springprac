<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%@ include file="/WEB-INF/views/common/import.jsp"%>

<body>
	<input type = "number" readonly id="ktNum" placeholder = "번호" value = "${kt.ktNum }"><br>
	<input type = "text" id="ktName" placeholder = "이름" value = "${kt.ktName }">
	<input type = "text" id="ktId" placeholder = "id" value = "${kt.ktId }">
	<input type = "number" id="ktAge" placeholder = "나이" value = "${kt.ktAge }">
	<input type = "number" id="ktKda" placeholder = "kda" value = "${kt.ktKda }"><br>
	<input type = "text" id="ktProfile" placeholder = "프로필" value = "${kt.ktProfile }"><br>
	
	<button onclick = 'updateKtRolster()'>수정</button>
	<button onclick = 'history.back()'>뒤로가기</button>
	<button onclick = 'deleteKtRolster()'>삭제</button>
	
	<script>
		function updateKtRolster(){
			const ktNum = document.querySelector('#ktNum').value;
			const kt = getParams();
			
			fetch('/kt-list/update/'+ktNum, {
				method: 'PATCH',
				headers:{
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(kt, ktNum)
			})
			.then(function (res){
				return res.json();
			})
			.then(function (data){
				if(data==1){
					alert('성공');
					location.href = '/kt-list';
				}
			});
		}
		
		function deleteKtRolster(){
			const ktNum= document.querySelector('#ktNum').value;
			
			fetch('/kt-list/delete/' + ktNum,{
				method:'DELETE',
				headers:{
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(ktNum)
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data==1){
					alert('성공');
					location.href = '/kt-list';
				}
			});
		}
	</script>
</body>
</html>