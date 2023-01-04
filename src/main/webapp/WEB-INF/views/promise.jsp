<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<script>
		function fetch2(url, config){
			return new Promise(function(resolve, reject){
				const xhr = new XMLHttpRequest();
				xhr.open('GET', url);
				xhr.onreadystatechange = function(){
					if(xhr.readyState === xhr.DONE){
						if(xhr.status === 200){
							resolve(xhr.responseText);
						} else{
							reject(xhr.responseText);
						}
					}
				}
				xhr.send();
			})
		} //fetch 풀어쓴거
		
		fetch2('/test/3')
		.then(function(res){
			document.write(res);
			return fetch2('/test/2');
		})
		.then(function(res){
			document.write(res);
			return fetch2('/test/2');
		})
		.catch(function(err){
			alert(err);
		});
	</script>
</body>
</html>