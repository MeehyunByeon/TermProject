<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login_join.css">
<title>PT-Find Member Information</title>
</head>
<body>
<div id="wrap"> <%@ include file="/header.jsp" %>

	<div id="contents">
        <%
		boolean find = (boolean)request.getAttribute("find");
      	%>
        <section>
        <div id="log">
          <fieldset>
          <legend>${result }</legend>
          	<p>${msg }</p>
          	<% if(find) {%>
           	<form id="log" action="login.jsp" method="post">
            	<input type="submit" value="로그인">
            </form>
            <%} else{ %>
            <form id="log" action="findIdPwd.jsp" method="post">
           		<input type="submit" value="아이디 | 비밀번호 찾기">
          	</form>
          	<form id="log" action="join.jsp" method="post">
           		<input type="submit" value="회원가입">
          	</form>
          	<%} %>
          </fieldset>
          </div>
        </section>          
        </div>
        
<%@ include file="/footer.jsp" %></div>
</body>
</html>