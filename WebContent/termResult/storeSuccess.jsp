<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login_join.css">
<title>PT - Store Success</title>
</head>
<body>
 <div id="wrap"> <%@ include file="/header.jsp" %>
	<div id="contents">
        <section>
        <div id="log">
          <fieldset>
          <legend>${result }</legend>
          	<p>${msg }</p>
           	<form id="log" action="allterm.do" method="post">
            	<input type="submit" value="용어 목록">
            </form>
            <form id="log" action="storage.do" method="post">
           		<input type="submit" value="보관함">
          	</form>
          </fieldset>
          </div>
        </section>          
        </div>
        <%@ include file="/footer.jsp" %>
    </div>
</body>
</html>