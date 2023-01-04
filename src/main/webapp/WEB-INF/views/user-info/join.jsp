<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/import.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<input type = "text" id = "uiName" placeholder = "이름"><br>
	<input type = "text" id = "uiId" placeholder = "id"><button onclick ="checkId()">중복확인</button><br>
	<input type = "text" id = "uiPwd" placeholder = "비밀번호"><br>
	<input type = "password" id = "uiPwdCheck" placeholder = "비밀번호확인"><br>
	<input type = "text" id = "uiEmail" placeholder = "이메일"><br>
	<input type = "text" id = "uiZip" placeholder = "우편번호" disabled><button onclick="searchAddr()">검색</button><br>
	<input type = "text" id = "uiAddr1" placeholder = "주소" disabled><br>
	<input type = "text" id = "uiAddr2" placeholder = "상세주소"><br>
	<input type = "text" id = "uiProfile" placeholder = "프로필"><br>
	<button onclick = "join()">회원가입</button>
	<!-- <input type = "text" id = "uiProfileImgPath" placeholder = "이름"><br>-->
	
	<script>
		function searchAddr(){
			const daumWin = new daum.Postcode({ //다음 지도 API
				oncomplete:function(data){ // 선택 :zonecode와 address(도로명주소)
					console.log(data);
			    	document.querySelector('#uiZip').value = data.zonecode;
			    	document.querySelector('#uiAddr1').value = data.address;
				},
			    onsearch: function(data) { //검색후의 결과
			    	console.log(data);
			    }
			});
			daumWin.open();
		}
		
		let checkedId =false;
		function checkId(){
			const uiId = document.querySelector('#uiId').value;
			
			if(uiId.trim().length<4){
				alert('id는 4글자 이상');
				uiId.focus();
				return;
			}
			
			fetch('/user-infos/check/'+uiId)
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				console.log(data);
				if(data===false){
					alert('사용가능한 id');
					isCheckedId = true;
				}
				else{
					alert('사용불가능');
					isCheckedId = false;
				}
			});
		}
		
		function join(){
			const uiPwd = document.querySelector('#uiPwd');
			const uiPwdCheck = document.querySelector('#uiPwdCheck');
			const uiId = document.querySelector('#uiId');
			
			if(uiId.value.trim().length<4){
				alert('id는 4글자 이상');
				uiId.focus();
				return;
			}
			
			if(uiPwd.value.trim().length <6){
				alert('비밀번호는 6자 이상');
				uiPwd.focus();
				return;
			}
			
			if(uiPwd.value.trim()!=uiPwdCheck.value.trim()){
				alert('비밀번호 확인 바람');
				uiPwdCheck.focus();
				return;
			}
			
			if(!isCheckedId){
				alert('id중복확인바람');
				return;
			}
			
			const ui = getParams();
			
			fetch('/user-infos/insert',{
				method : 'POST',
				headers :{
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(ui)
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data===1){
					alert('회원가입 성공');
					location.href = '/views/user-info/login';
				}
			});
			
			
		}
	</script>
 </body>
</html>