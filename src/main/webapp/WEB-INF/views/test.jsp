<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		window.addEventListener('load',async function(){
		});
		function setPromise(cnt){
			return new Promise(function(resolve, reject){
				setTimeout(function(){
					document.write(cnt);
					resolve(); /* 끝날때까지 기다림 */
				},cnt*1000);
			});
		}
		
		setPromise(4)
		.then(()=>{
			return setPromise(3);
		})
		.then(()=>{
			return setPromise(2);
		})
		.then(()=>{
			return setPromise(1);
		});
		
 		async function allAsync(){
 			await setPromise(4);
 			await setPromise(3);
 			await setPromise(2);
 			await setPromise(1);
 		}
 		allAsync();/* 44 33 22 11 */
	</script>
</body>
</html>