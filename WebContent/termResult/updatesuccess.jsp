<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login_join.css">
<title>PT - Member Update Success</title>
</head>
<body>
<div id="wrap"> 
	<%@ include file="/header.jsp" %>
	
		<div id="contents">
        <section>
        <div id=log>
          <fieldset>
          <legend>회원정보 수정 성공</legend>
          	<p>${id }의 회원정보가 성공적으로 수정되었습니다.</p>
           	<form id="log" action="main.do" method="post">
            	<input type="submit" value="메인으로">
            </form>
            <form id="log" action="myinfo.do" method="post">
           		<input type="submit" value="나의 정보">
          	</form>
          </fieldset>
          </div>
        </section>          
        </div>
        
	<%@ include file="/footer.jsp" %>
	</div>
</body>
</html>