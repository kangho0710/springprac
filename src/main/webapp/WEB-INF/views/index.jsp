<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화면</title>
</head>
<body>
<c:if test ="${userInfo eq null}">
로그인점 ㅎ
<a href = "/views/user-info/login">로그인</a><br>
<a href = "/views/user-info/join">회원가입</a><br>
</c:if>

<c:if test="${userInfo ne null}">
안녕하세요 ${userInfo.uiName }님<br>
<a href = "/views/user-info/view">회원정보</a><br>
<a href = "/views/board-info/list">게시판</a>
<button onclick = "logOut()">로그아웃</button>
</c:if>

<script>
	function logOut(){
		fetch('/user-infos/logout')
		.then(function(res){
			return res.json();
		})
		.then(function(data){
			if(data === true){
				alert('로그아웃');
				location.href = '/';
			}
		})
	}
</script>
</body>
</html>