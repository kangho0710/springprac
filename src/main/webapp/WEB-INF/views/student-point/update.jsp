<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/import.jsp"%>
</head>
<body>
	<input type = "number" readonly id="spNum" placeholder = "번호"><br>
	<input type = "text" id="spName" placeholder = "이름">
	<input type = "number" id="spKorPoint" placeholder = "국어">
	<input type = "number" id="spEngPoint" placeholder = "영어">
	<input type = "number" id="spMathPoint" placeholder = "수학"><br>
	<input type = "text" id="spProfile" placeholder = "프로필"><br>
	
	<button onclick = 'updateStudentPoint()'>수정</button>
	<button onclick = 'deleteStudentPoint()'>삭제</button>
	<button onclick = 'history.back()'>돌아가기</button>
	<script>
	
	window.onload= function(){
		const spNum = '${param.spNum}';
		
		fetch('/student-points/view?spNum='+spNum)
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			let html = '';
			const tdObjs = document.querySelectorAll('input[id]');
			for(const tdObj of tdObjs){
				tdObj.value = data[tdObj.getAttribute('id')];
			}
		});
	}
	
	function updateStudentPoint(){
		const spNum= document.querySelector('#spNum').value;
		const sp = getParams();
				 
		fetch('/student-points/update/'+spNum,{
			method:'PATCH',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(sp, spNum)
			
		})
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			if(data==1){
				alert('성공');
				location.href = '/views/student-point/list';
			}
		});
	}
	
	function deleteStudentPoint(){
		const spNum= document.querySelector('#spNum').value;
		
		fetch('/student-points/delete/'+spNum, {
			method:'DELETE',
			headers:{
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(spNum)
		})
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			if(data==1){
				alert('성공');
				location.href = '/views/student-point/list';
			}
		});
		
	}
	
	</script>
</body>
</html>