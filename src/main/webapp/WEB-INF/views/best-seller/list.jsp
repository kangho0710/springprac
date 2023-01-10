<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="/resources/js/jquery.min.js"></script> 
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="/resources/js/trirand/i18n/grid.locale-kr.js"></script>
    <!-- This is the Javascript file of jqGrid -->   
    <script type="text/ecmascript" src="/resources/js/trirand/jquery.jqGrid.min.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc.
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> 
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/trirand/ui.jqgrid-bootstrap.css" />

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<div style="margin-left:20px">
		<table id="jqGrid"></table>
		<div id="gqGridpager"></div>
	</div>
	
	<script>
		$(document).ready(function(){
			const config ={
					url: '/best-seller',
					mtype: 'GET',
					styleUI : 'Bootstrap',
					datatype: 'jsonp',
					pager: '#gqGridpager',
					colModel : [
						{label:'순위', name:'bsNum', key:true, width:60},
						{label:'제목', name:'bsTitle', key:true, width:200},
						{label:'저자', name:'bsAuthor', key:true, width:200},
						{label:'출판사', name:'bsPublisher', key:true, width:200},
						{label:'발행일', name:'bsDate', key:true, width:200},
						{label:'가격', name:'bsPrice', key:true, width:200}
						//label: 화면에 보여지는 것
						// key: 화면에 쓰겠다는 뜻
						// name에는 VO에서 해당하는 것으로
					]
			}
			$('#jqGrid').jqGrid(config);
		})
	</script>
</body>
</html>