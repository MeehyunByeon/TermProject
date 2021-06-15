<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.term.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="utf-8" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="css/login_join.css">
    <title>PT - My Information</title>
</head>
<body>
    <div id="wrap">
    	<%@ include file="/header.jsp" %>
    	<%
    	ArrayList<Term> myenroll = (ArrayList<Term>)request.getAttribute("myenroll");
      	request.setAttribute("myenroll", myenroll);
      	String myenrollresult = (String)request.getAttribute("myenrollresult");
      	String myenrollmsg = (String)request.getAttribute("myenrollmsg");
      	%>
      	
   	<div id="contents">
      <section id="myinfo">
      <form id="join" action="update.do" method="post">
        <fieldset>MY</fieldset>
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
            <label for="email">이메일</label>
            <input id="mail" name="email" type="email" value="${memInfo.getEmail()}" required placeholder="abc@domain.com">
          </li>
        </ul>
        </fieldset>
      	<fieldset>
        <input type="submit" value="수정하기">
      </form>
        	<form action="logout.jsp" method="put">
        		<input type="submit" value="로그아웃">
        	</form>
        	<% if(sessionId.equals("manager")){%>
        	<form id="manager" action="manager.do" method="put">
        		<input name="manager" type="submit" value="관리자">
        	</form>
        	<%} %>
      	</fieldset>
      </section>
    
    <div id="myenroll">
     	<% if(myenrollresult == null) { %>
			<table id="table_myenroll">
				<caption>내가 등록한 용어 목록</caption>
          				<tr><th>번호</th><th>용어</th><th>카테고리</th><th>등록 날짜</th><th>조회수</th><th>수정</th><th>삭제</th></tr>
				<% for(int i = 0; i < myenroll.size(); i++){
					Term t = myenroll.get(i);	%>
					<tr><form action="termUpdate.jsp" method="put">
							<input type="hidden" name="term" value="<%=t.getTerm() %>">
							<%request.setAttribute("term", t.getTerm()); %>
							<input type="hidden" name="con" value="<%=t.getTermcon() %>">
						 	<td><%= i+1%></td>
						 	<td><%=t.getTerm() %></td>
						 	<td><%=t.getTermcate() %></td>
						 	<td><%=t.getTermdate() %></td>
						 	<td><%=t.getTermhits() %></td>
						 	<td><input type="submit" name="update" value="수정"/></td>
					</form>
					 <form id="termdelete" action="termdelete.do" method="put">
						 	<input type="hidden" name="term" value="<%=t.getTerm() %>">
						 	<td><input type="submit" name="delete" value="삭제" /></td>
						</form></tr>
				<% }
		}else{%>
				<h2><%= myenrollresult%></h2>
				<h3><%= myenrollmsg%></h3>
		<% }%>
		</table>
     </div>
     </div>
    <%@ include file="/footer.jsp" %>
    </div>
</body>
</html>