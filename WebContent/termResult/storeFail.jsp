<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login_join.css">
<title>PT - Store Fail</title>
</head>
<body>
 <div id="wrap"> <%@ include file="/header.jsp" %>
	<div id="contents">
        <section>
        <div id="log">
          <fieldset>
          <legend>저장 실패</legend>
          	<p>${msg1 }</p><br>
          	<p>${msg2 }</p>
           	<form id="log" action="login.jsp" method="post">
            	<input type="submit" value="로그인">
            </form>
            <form id="log" action="join.jsp" method="post">
           		<input type="submit" value="회원가입">
          	</form>
          </fieldset>
          </div>
        </section>          
        </div>
        <%@ include file="/footer.jsp" %>
    </div>
</body>
</html>