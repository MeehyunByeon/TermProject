<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login_join.css">
<title>PT_logout</title>
</head>
<body>
<div id="wrap"> 
<%@ include file="/header.jsp" %>
	<div id="contents">
        <section>
        <div id="log">
          <fieldset>
          <legend>로그아웃 성공</legend>
          	<p>${sessionId }님 로그아웃 되었습니다.</p>
			<%session.invalidate();%>
           	<form id="log" action="login.jsp" method="post">
            	<input type="submit" value="로그인">
            </form>
            <form id="log" action="start.jsp" method="post">
           		<input type="submit" value="메인으로">
          	</form>
          </fieldset>
          </div>
        </section>          
        </div>
	
	<%@ include file="/footer.jsp" %>
	</div>
</body>
</html>