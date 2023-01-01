<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type = "text" id="spName" placeholder = "이름"><button onclick="getStudentPoints()">검색</button>
	<table border ="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>프로필</th>
		</tr>
		<tbody id = "tBody">
		</tbody>
	</table>
	<button onclick = "location.href = '/views/student-point/insert'">등록</button>
	<script>
	
		function getStudentPoints(){
			fetch('/student-points?spName='+document.querySelector('#spName').value) //fetch(promise타입)가 끝나면then실행 
			.then(function(res){
				return res.json(); //JSON.parse
			})
			.then(function(data){ //parsing된 결과
				console.log(data);
				let html='';
				for(let i=0; i<data.length; i++){
					const studentPoint = data[i];
					html+= '<tr style="cursor:pointer" onclick="location.href=\'/views/student-point/view?spNum='+ studentPoint.spNum +'\' ">';
					html+='<td>' + studentPoint.spNum + '</td>';
					html+='<td>' + studentPoint.spName + '</td>';
					html+='<td>' + studentPoint.spKorPoint + '</td>';
					html+='<td>' + studentPoint.spEngPoint + '</td>';
					html+='<td>' + studentPoint.spMathPoint + '</td>';
					html+='<td>' + studentPoint.spProfile + '</td>';
					html+='</tr>';
				}
				document.querySelector('#tBody').innerHTML = html;
			});
			
		}
		
		window.onload = function(){
			getStudentPoints();
		}
	</script>
</body>
</html>