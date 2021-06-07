<%@page import="cs.term.vo.Member"%>
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
      <section>
      <form id="join" action="update.do" method="post">
        <fieldset><h1>MY</h1></fieldset>
      	<fieldset>
      	<legend>회원 정보</legend>
        <ul>
          <li>
            <label for="id">아이디</label>
            <input id="id" name="id" type="text" value="${memInfo.getId()}" readonly>
          </li>
          <li>
            <label for="pwd">비밀번호</label>
            <input id="pwd" name="pwd" type="password" value="${memInfo.getPwd()}" required placeholder="문자, 숫자, 특수기호 포함 9자 이상">
          </li> 
          <li>
            <label for="name">이름</label>
            <input id="name" name="name" type="text" value="${memInfo.getName()}" required>
          </li>
          <li>
            <label for="tel">전화번호</label>
            <input id="tel" name="tel" type="text" value="${memInfo.getTel()}" required placeholder="01012345678">
          </li>
          <li>
            <label for="mail">이메일</label>
            <input id="mail" name="mail" type="email" value="${memInfo.getEmail()}" required placeholder="abc@domain.com">
          </li>
        </ul>
        </fieldset>
      	<fieldset>
        <input type="submit" value="수정하기">
      </form>
        	<form action="logout.jsp" method="put">
        		<input type="submit" value="로그아웃">
        	</form>
      	</fieldset>
      </section>
    </div>
        
       <%@ include file="/footer.jsp" %>

    </div>
</body>
</html>