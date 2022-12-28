<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/bootstrap-grid.css">
<link rel="stylesheet" href="/resources/css/bootstrap-reboot.css">
<link rel="stylesheet" href="/resources/css/bootstrap-utilities.css">
<script src="/resources/js/bootstrap.bundle.js"></script>
<!--  <script src="/resources/js/bootstrap.esm.js"></script>-->
<script src="/resources/js/bootstrap.js"></script>
<script>
	function getParams(){
		const inputObjs = document.querySelectorAll('select[id],input[id],textarea[id]');
		const params = {}
		for(const inputObj of inputObjs){
			params[inputObj.getAttribute('id')]=inputObj.value;
		}
		return params;
	}
</script>