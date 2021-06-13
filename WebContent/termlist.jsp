<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/term_req_st.css">
    <title>PT-Programing Term</title>
</head>
<body>
<div id="wrap">
    	<%@ include file="/header.jsp" %>

        <div class="contents">
        <form action="research.do" method="put">
          <input id="researchText" type="text" name="research">
          <input id="researchSubmit" type="submit" value="검색"></input>
          <input id="researchSubmit" type="submit" name="enroll" value="용어 등록"></input>
        </form>
        
		<%
		ArrayList<Term> all = (ArrayList<Term>)request.getAttribute("all");
      	request.setAttribute("all", all);
      	int i=0;
		if(!all.isEmpty()) { %>
			<div id="listWrapper">
				<table id="table">
          				<tr><th>번호</th><th>용어</th><th>카테고리</th><th>날짜</th><th>조회수</th><th>등록자</th></tr>
				<% for(i = 0; i < all.size(); i++){
					Term term = all.get(i);	%>
					<tr><form action="connect.do" method="put">
						 	<input type="hidden" name="term" value="<%=term.getTerm() %>">
						 	<td><%= i+1%></td>
						 	<td><input id="" type="submit" name="term" value="<%=term.getTerm() %>"/></td>
							<td><%=term.getTermcate() %></td>
							<td><%=term.getTermdate() %></td>
							<td><%=term.getTermhits() %></td>
							<td><%=term.getTermmem() %></td>
					</form></tr>
				<% }
		} else out.print("<h3>용어 없음</h3>");%>
        </table>
          	</div>
        </div>
        <%@ include file="/footer.jsp" %>
</div>
</body>
</html>