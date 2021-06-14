<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/login_join.css">
    <title>PT - Join</title>
</head>
<body>
    <div id="wrap">
    	<%@ include file="/header.jsp" %>

    <div id="contents">
      <section>
      <form id="join" action="join.do" method="post">
        <fieldset>회원가입</fieldset>
      	<fieldset>
      	<legend>회원정보</legend>
        <ul>
          <li>
            <label for="id">아이디</label>
            <input id="id" name="id" type="text" required autofocus placeholder="4자 ~ 10자">
          </li>
          <li>
            <label for="pwd">비밀번호</label>
            <input id="pwd" name="pwd" type="password" required placeholder="문자, 숫자, 특수기호 포함 9자 이상">
          </li> 
          <li>
            <label for="name">이름</label>
            <input id="name" name="name" type="text" required>
          </li>
          <li>
            <label for="tel">전화번호</label>
            <input id="tel" name="tel" type="tel" required placeholder="01012345678">
          </li>
          <li>
            <label for="email">이메일</label>
            <input id="email" name="email" type="email" placeholder="abc@domain.com" required>
          </li>
        </ul>
      </fieldset>
      <fieldset>
        <legend>이용약관 및 알림 수신</legend>
        <label for="agree">이용약관동의
        <input type="checkbox" name="agree" required></label>
        <label for="mail_y">메일 수신 
        <input type="radio" name="mailing" value="mail_y" checked> </label>
        <label for="mail_n">메일 수신 안 함  
        <input type="radio" name="mailing" value="mail_n" ></label>     
      </fieldset>
      <fieldset>
        <button type="submit"> 회원가입 </button> 
      </fieldset>
      </form>
      </section>
    </div>
        
        <%@ include file="/footer.jsp" %>

    </div>
</body>
</html>