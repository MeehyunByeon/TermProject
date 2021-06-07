<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login_join.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrap"> 
	<%@ include file="/header.jsp" %>
	
		<div id="contents">
        <section>
        <div id=log>
          <fieldset>
          <legend>회원가입 성공</legend>
          <p>${id }님 회원이 되신 것을 환영합니다</p>
          <form id="log" action="login.jsp" method="post">
           		<input type="submit" value="로그인">
          	</form>
           	<form id="log" action="main.do" method="post">
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