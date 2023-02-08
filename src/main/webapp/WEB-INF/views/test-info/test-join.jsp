<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>id</th>
			<td><input type="text" id="uiId" placeholder="id">&nbsp
				<button onclick="checkId()">중복확인</button></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="uiPwd" placeholder="비밀번호"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" id="uiPwdCheck" placeholder="비밀번호확인"></td>
		</tr>

		<tr>
			<th>이름</th>
			<td><input type = "text" id = "uiName" placeholder = "이름"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type = "text" id = "uiEmail" placeholder = "이메일">@<input type = "text" id = "uiEmail2" placeholder = "이메일"></td>
		</tr>
		<tr>
			<th>비밀번호 확인 질문</th>
			<td><select id="uiPwdQuestion">
			      <option value="선택">=====선택======
			      <option value="지금다니는 학원은?">지금다니는 학원은?
			    </select></td>
		</tr>
		<tr>
			<th>비밀번호 확인 답변</th>
			<td><input type = "text" id = "uiPwdAnswer" placeholder = "비밀번호확인 답변"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><input type="radio" id="uiGender">남성<input type="radio" id="uiGender">여성</td>
		</tr>
		
		<tr>
			<th>생년월일</th>
			<td><select id="uiYear">
			      <option value="선택">=====선택======
			      <option value="1996">1996
			    </select>
			    <select id="uiMonth">
			      <option value="선택">=====선택======
			      <option value="05">05
			    </select>
			    <select id="uiDay">
			      <option value="선택">=====선택======
			      <option value="23">23
			    </select>
			</td>
		</tr>
	</table>
	<button onclick="join()">회원가입</button>
	
	<script>
	let checkedId =false;
	function checkId(){
		const uiId = document.querySelector('#uiId').value;
		
		if(uiId.trim().length<4){
			alert('id는 4글자 이상');
			return;
		} else if(uiId.trim().length>10){
			alert('id는 10글자 미만');
			return;
		}else{
			alert('사용가능한 id');
		}
		
	}
	
		function join(){
			const uiPwd = document.querySelector('#uiPwd');
			const uiPwdCheck = document.querySelector('#uiPwdCheck');
			const uiId = document.querySelector('#uiId');
			const uiEmail = document.querySelector('#uiEmail');
			const uiEmail2 = document.querySelector('#uiEmail2');
			const uiGender = document.querySelector('#uiGender');
			
			if(uiId.value.trim().length<4){
				alert('id는 4글자 이상');
				uiId.focus();
				return;
			} else if(uiId.value.trim().length>10){
				alert('id는 10글자 미만');
				uiId.focus();
				return;
			}
			
			if(uiPwd.value.trim().length <8){
				alert('비밀번호는 8자 이상');
				uiPwd.focus();
				return;
			} else if(uiPwd.value.trim().length>10){
				alert('비밀번호는 10자 미만');
				uiPwd.focus();
				return;
			}
			
			if(uiPwd.value.trim()!=uiPwdCheck.value.trim()){
				alert('비밀번호 확인 바람');
				uiPwdCheck.focus();
				return;
			}
			
			if(document.querySelector('#uiName').value.trim().length===0){
				alert('이름을 입력해주세요');
				return;
			}
			if(uiEmail.value.trim().length===0 && uiEmail2.value.trim().length===0){
				alert('email을 입력해주세요');
				return;
			}
			
			alert('가입성공');
			location.reload();
		}
	</script>
</body>
</html>