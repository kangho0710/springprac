<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	국어<input type = "number" id="spKorPoint1" value="0">~<input type="number" id ="spKorPoint2" value="0"><br>
	영어<input type = "number" id="spEngPoint1" value="0">~<input type="number" id ="spEngPoint2" value="0"><br>
	수학<input type = "number" id="spMathPoint1" value="0">~<input type="number" id ="spMathPoint2" value="0"><br>
	합계<input type = "number" id="spTotalPoint1" value="0">~<input type="number" id ="spTotalPoint2" value="0"><br>
	<input type = "text" id="spName" placeholder = "이름"><button onclick="getStudentPoints()">검색</button>
	<table border ="1">
		<tr>
			<th><input type = "checkbox" name="allCheck" onclick="toggleCheck(this)"></th>
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
	<button onclick = "deleteStudentPoints()">삭제</button>
	<script>
		function deleteStudentPoints(){
			const spNumObjs = document.querySelectorAll('input[name="spNums"]:checked');
			const spNums = [];
			for(const spNumObj of spNumObjs){
				spNums.push(spNumObj.value);
			}
			console.log(spNums);
			
			if(spNums.length===0){
				alert('선택바람');
				return;
			}
			
			const param = {
					spNums:spNums
			}
			fetch('/student-points/deletes',{
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
					alert('성공')
					location.href='/views/student-point/list';
				}
			})
			
			
		}
		
		function toggleCheck(obj){
			//input태그의 name이 spNums인 것을 모두 찾아내서 allCheck의 checked가 true이면 모두 체크, 아니면 모두 미체크
			const spNums = document.querySelectorAll('input[name="spNums"]');
			for(const spNum of spNums){
				spNum.checked = obj.checked;
			}
		}
	
		function getStudentPoints(){
			let param = '?spName=' + document.querySelector('#spName').value;
			param += '&spKorPoint1=' + document.querySelector('#spKorPoint1').value;
			param += '&spKorPoint2=' + document.querySelector('#spKorPoint2').value;
			param += '&spEngPoint1=' + document.querySelector('#spEngPoint1').value;
			param += '&spEngPoint2=' + document.querySelector('#spEngPoint2').value;
			param += '&spMathPoint1=' + document.querySelector('#spMathPoint1').value;
			param += '&spMathPoint2=' + document.querySelector('#spMathPoint2').value;
			param += '&spTotalPoint1=' + document.querySelector('#spTotalPoint1').value;
			param += '&spTotalPoint2=' + document.querySelector('#spTotalPoint2').value;
			
			
			fetch('/student-points' + param) //fetch(promise타입)가 끝나면then실행 
			.then(function(res){
				return res.json(); //JSON.parse
			})
			.then(function(data){ //parsing된 결과
				console.log(data);
				let html='';
				for(let i=0; i<data.length; i++){
					const studentPoint = data[i];
					html+='<tr>'
					html+='<td><input type="checkbox" name = "spNums" value="'+ studentPoint.spNum + '"></td>'
					html+='<td>' + studentPoint.spNum + '</td>';
					html+='<td><a href = "/views/student-point/view?spNum=' + studentPoint.spNum +'">' + studentPoint.spName + '</a></td>';
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