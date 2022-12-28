<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/shop-info">
		<input readonly type="text"  name="siCode" placeholder="코드" value = "${shopInfo.siCode }">
		 <input readonly type="text" name="siName" placeholder="제목" value = "${shopInfo.siName }"> 
		 <input readonly type="text" name="siCategory" placeholder="카테고리" value = "${shopInfo.siCategory }">
		<br><input readonly type="text" name="siStock" placeholder="재고" value = "${shopInfo.siStock }">
			<input readonly type="text" name="siSupplier" placeholder="유통" value = "${shopInfo.siSupplier }"> 
			<input readonly type="text" name="siPrice" placeholder="가격" value = "${shopInfo.siPrice }"> <br>
		<textarea readonly name="siEtc" rows="5" cols="40" placeholder="내용">"${shopInfo.siEtc }"
		</textarea>
	</form>
	
	<button onclick = "location.href= '/shop-info/update?siNum=${shopInfo.siNum}'">수정하러가기</button>

</body>
</html>