<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/shop-infos/update">
		<input type="hidden"  name="siNum" placeholder="넘버" value = "${shopInfo.siNum }">
		<input type="text"  name="siCode" placeholder="코드" value = "${shopInfo.siCode }">
		 <input type="text" name="siName" placeholder="제목" value = "${shopInfo.siName }"> 
		 <input type="text" name="siCategory" placeholder="카테고리" value = "${shopInfo.siCategory }">
		<br><input type="text" name="siStock" placeholder="재고" value = "${shopInfo.siStock }">
			<input type="text" name="siSupplier" placeholder="유통" value = "${shopInfo.siSupplier }"> 
			<input type="text" name="siPrice" placeholder="가격" value = "${shopInfo.siPrice }"> <br>
		<textarea name="siEtc" rows="5" cols="40" placeholder="내용">"${shopInfo.siEtc }"
		</textarea>
		<button>수정하기</button>
		<button formaction="/shop-infos/delete">삭제</button>
	</form>
	

</body>
</html>