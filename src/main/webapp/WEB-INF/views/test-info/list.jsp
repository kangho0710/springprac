<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type = "text" id="tiName" placeholder = "이름"><button onclick="getTestInfoList()">검색</button>
	<table border ="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<tbody id = "tBody">
		</tbody>
	</table>
	
	<script>
		function getTestInfoList(){
			fetch('/test-info/list?tiName='+document.querySelector('#tiName').value)
			.then(function(test){
				return test.json();
			})
			.then(function(data){
				let html = '';
				for(var i=0; i<data.length; i++){
					const testInfo = data[i];
					html += '<tr>';
					html += '<td>' + testInfo.tiNum + '</td>'
					html += '<td>' + testInfo.tiName + '</td>'
					html += '<td>' + testInfo.tiAge + '</td>'
					html += '<td>' + testInfo.tiAddress + '</td>'
					html += '</tr>'
				}
				document.querySelector('#tBody').innerHTML = html;
			});
		}
		
		window.onload = function(){
			getTestInfoList();
		}
	</script>
</body>
</html>