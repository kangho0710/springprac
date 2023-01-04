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
	
	
</body>
</html>