<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호 : ${userInfo.uiNum}<br>
이름 : ${userInfo.uiName}<br>
id : ${userInfo.uiId}<br>
email : ${userInfo.uiEmail}<br>
우편번호 : ${userInfo.uiZip}<br>
주소 : ${userInfo.uiAddr1}<br>
상세주소 : ${userInfo.uiAddr2}<br>
프로필 : ${userInfo.uiProfile}<br>

<button onclick = "showConfirm('update')">정보 수정</button>
<button onclick = "showConfirm('delete')">회원 탈퇴</button>

	<c:if test="${userInfo.uiProfileImgPath ne null}">
		사진:<img src = "${userInfo.uiProfileImgPath}"><br>
	</c:if>
	
	<div id="confirm" style="display: none">
		<input type="password" id="uiPwd" placeholder="비밀번호">
		<button onclick="passwordConfirm()">확인</button>
		<!-- 수정,탈퇴전에 비밀번호 확인(백엔드에서 처리) -->
	</div>
	
	<script>
		let _type;
		function showConfirm(type){
			_type = type;
			document.querySelector('#confirm').style.display = '';
		}
		
		function passwordConfirm(){
			let method = 'POST' /* 업데이트 */
			if(_type==='delete'){
				method = 'DELETE'
			}	
			const param = {
					uiPwd : document.querySelector('#uiPwd').value
			}
			fetch('/user-infos/${userInfo.uiNum}',{
				method: method,
				headers :{
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(param)
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data === true){
					if(_type === 'update'){
						location.href = '/views/user-info/update';
					} else if(_type === 'delete'){
						alert('삭제완료');
						location.href = '/';
					}
				} else{
					alert('비밀번호 다시 확인');
					return;
				}
			});
		}
		
	</script>
</body>
</html>