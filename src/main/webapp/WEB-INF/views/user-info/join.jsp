<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="/WEB-INF/views/common/import.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<input type = "text" id = "uiId" placeholder ="아이디"><button onclick = "checkId()">중복확인</button><br>
	<input type = "text" id = "uiName" placeholder ="이름"><br>
	<input type = "text" id = "uiPwd" placeholder ="비밀번호"><br>
	<input type = "password" id = "uiPwdCheck" placeholder ="비밀번호확인"><br>
	<input type = "email" id = "uiEmail" placeholder ="이메일"><br>
	<input type = "text" id = "uiZip" disabled><button onclick = "searchAddr()">주소검색</button><br>
	<input type = "text" id = "uiAddr1" disabled><br>
	<input type = "text" id = "uiAddr2" placeholder ="상세주소"><br>
	<input type = "text" id ="uiProfile" placeholder ="프로필"><br>
	<button onclick="join()">회원가입</button>
	
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
	
	
	let isCheckedId = false;
	
		function checkId(){ //중복확인 로직
			const uiId = document.querySelector('#uiId').value;
			if(uiId.trim().length<4){
				alert('아이디는 4글자 이상');
				return;
			}
			
			fetch('/user-infos/check/' + uiId)
			.then(function(data){
				return data.json();
			})
			.then(function(res){
				console.log(res);
				if(res===false){
					alert('사용가능한 id');
					isCheckedId = true;
				}
			});
		}
		
		
		function join() { //회원가입 로직
			const pwd = document.querySelector('#uiPwd');
			const pwdCheck = document.querySelector('#uiPwdCheck');

			const uiId = document.querySelector('#uiId');

			if (uiId.value.trim().length < 4) {
				alert('아이디는 4글자 이상');
				uiId.focus();
				return;
			}

			if (pwd.value.trim().length < 6) {
				alert('비밀번호는 6글자 이상');
				pwd.focus();
				return;
			}

			if (pwd.value.trim() != pwdCheck.value.trim()) { //비밀번호확인
				alert('비밀번호 확인');
				pwdCheck.value = '';
				pwdCheck.focus();
				return;
			}

			if (!isCheckedId) {
				alert('중복확인바람');
				return false;
			}

			const ui = getParams();
			fetch("/user-infos/insert", {
				method : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(ui)
			}).then(function(res) {
				if (res === false) {
				}
				return res.json();
			}).then(function(data) {
				if (data == 1) {
					alert('성공');
					location.href = '/views/index';
				}
			});
		}
	</script>
	
</body>
</html>