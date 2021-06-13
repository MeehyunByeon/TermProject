<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.term.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="css/login_join.css">

<title>PT-Manager</title>
</head>
<body>
    <div id="wrap">
    	<%@ include file="/header.jsp" %>
    	<div id="contents">
    	<%
    	ArrayList<Term> allterms = (ArrayList<Term>)request.getAttribute("allterms");
      	request.setAttribute("allterms", allterms);
      	ArrayList<Member> allmems = (ArrayList<Member>)request.getAttribute("allmems");
      	request.setAttribute("allmems", allmems);
      	%>
      	
      	<div id="myenroll">
      	<%if(allterms != null) {%>
				<table id="table_myenroll">
				<caption>모든 용어 목록</caption>
          				<tr><th>번호</th><th>용어</th><th>카테고리</th><th>등록 날짜</th><th>조회수</th><th>수정</th><th>삭제</th></tr>
				<% for(int i = 0; i < allterms.size(); i++){
					Term t = allterms.get(i);	%>
					<tr><form action="termUpdate.jsp" method="put">
						 	<input type="hidden" name="term" value="<%=t.getTerm() %>">
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
						 	<td><input type="submit" name="delete" value="삭제" onclick=send(this.form)/></td>
						</form></tr>
		<%} }else{%>
				<h2>용어 목록 없음</h2>
		<% }%>
		</table>
     </div>
      	
      <div id="myenroll">
     	<%if(allmems != null) {%>
			<table id="table_myenroll">
				<caption>모든 회원 목록</caption>
          				<tr><th>번호</th><th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>이메일동의</th></tr>
				<% for(int i = 0; i < allmems.size(); i++){
					Member m = allmems.get(i);	%>
					<tr><form action="termUpdate.jsp" method="put">
							<input type="hidden" name="member" value="<%=m.getId() %>">
						 	<td><%= i+1%></td>
						 	<td><%=m.getId() %></td>
						 	<td><%=m.getName() %></td>
						 	<td><%=m.getTel() %></td>
						 	<td><%=m.getEmail() %></td>
						 	<td><%=m.getMailing() %></td>
					</form></tr>
				<% }
		}else{%>
				<h2>회원 없음</h2>
		<% }%>
		</table>
      </div>
    </div>
    <%@ include file="/footer.jsp" %>
    </div>
</body>
</html>