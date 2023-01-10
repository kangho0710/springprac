<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
</head>
<body>
	<%-- <table border ="1">
		<tr>
			<th>제목</th>
			<td><input type = "text" id = "biTitle"></td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>${userInfo.uiId}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="40" id = "biContent"></textarea></td>
		</tr>
		
		<tr>
			<th colspan = "2">
				<button onclick = "insertBoardInfo()">등록</button>
				<button>리스트</button>
			</th>
		</tr>
	</table> --%>

	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" id="biTitle" name="subject"></td>
		</tr>
		<tr>
			<td colspan="2"><textarea class="summernote" id="biContent" name="memo"></textarea>
			</td>
		</tr>
		<tr>
			<th colspan = "2">
				<button onclick = "insertBoardInfo()">등록</button>
			</th>
		</tr>
	</table>

	
	<script>
		$('.summernote').summernote({
			height:150,
			lang: 'ko-KR',
			focus: true,
			toolbar :[
				['fontname',['fontname']],
				['fontsize',['fontsize']],
				['style',['bold','italic','underline','strikethrough','clear']],
				['color',['forecolor','color']],
				['table',['table']],
				['para',['ul','ol','paragraph']],
				['height',['height']],
				['insert',['picture','link','video']],
				['view',['codeview','fullscreen','help']]
			],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		});
	
		function insertBoardInfo(){
			const param = {};
			param.biTitle = document.querySelector('#biTitle').value;
			param['biContent'] = document.querySelector('#biContent').value;
			
			fetch('/board-infos',{
				method:'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
			})
			.then(async function(res){
				if(res.ok){
					return res.json();
				}else{
					const err = await res.text();
					throw new Error(err);
				}
			})
			.then(function(data){
				if(data===1){
					alert('정상등록 되었습니다.');
					location.href='/views/board-info/list';
				}
				
			})
			.catch(function(err){
				alert(err);
			});
		}
	
	</script>
</body>
</html>