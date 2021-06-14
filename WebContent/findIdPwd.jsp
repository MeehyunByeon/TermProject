<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/login_join.css">
<title>PT - Find ID & PWD</title>
</head>
<body>
 <div id="wrap">
    	<%@ include file="/header.jsp" %>
     
   	<div id="contents">
   	
      <div id="myinfo">
		<form id="join" action="findinfo.do" method="post">
      	<fieldset>
      	<legend>아이디 찾기</legend>
        <ul>
          <li>
            <label for="tel">전화번호</label>
            <input id="tel" name="fid_tel" type="text" required placeholder="01012345678">
          </li>
          <li>
            <label for="mail">이메일</label>
            <input id="mail" name="fid_mail" type="email" required placeholder="abc@domain.com">
          </li>
        </ul>
        </fieldset>
        <input type="submit" name="findid" value="아이디찾기">
        </form>
     </div>
     
       <section id="myenroll">
     <form id="join" action="findinfo.do" method="post">
      	<fieldset>
      	<legend>비밀번호 찾기</legend>
        <ul>
          <li>
            <label for="id">아이디</label>
            <input id="id" name="fpwd_id" type="text" required>
          </li>
          <li>
            <label for="mail">이메일</label>
            <input id="mail" name="fpwd_mail" type="email" required placeholder="abc@domain.com">
          </li>
        </ul>
        </fieldset>
        <input type="submit" name="findpwd" value="비밀번호찾기">
      	</form>
      </section>
     
     </div>
    <%@ include file="/footer.jsp" %>
</div>
</body>
</html>