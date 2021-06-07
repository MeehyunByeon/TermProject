<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
    <link rel="stylesheet" href="PT.css">
    <title>PT-Programing Term</title>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(document).ready(function(){
    $("#start").trigger("click");
}); 
</script>
<body>
	<form action="main.do" method="put">
		<input type="submit" id="start" vaule="">
	</form>
</body>
</html>