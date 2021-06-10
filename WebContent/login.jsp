<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/login_join.css">
    <title>PT-Programing Term</title>
</head>
<body>
    <div id="wrap">
    	<%@ include file="/header.jsp" %>


        <div id="contents">
        <section id="log">
          <form action="login.do" method="post">
          <fieldset>
          <legend>로그인</legend>
          <ul>
            <li>
              <label for="id">아이디</label>
              <input id="id" name="id" type="text" autofocus required>
            </li>
            <li>
              <label for="pwd">비밀번호</label>
              <input id="pwd" name="pwd" type="password" required>
            </li>
           </ul>
           <div id="logsub">
            <a href="findIdPwd.jsp">아이디 | 비밀번호 찾기</a>
           </div>
            <input type="submit" value="로그인">
          </fieldset>
          </form>
          
          <form action="join.jsp" method="put"><input type="submit" value="회원가입"></form>
          <form action="main.do" method="put"><input type="submit" value="메인으로"></form>
        </section>          
        </div>

       <%@ include file="/footer.jsp" %>

    </div>
</body>
</html>