<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/term_req_st.css">
    <title>PT - Storage</title>
</head>
<body>
<div id="wrap">
    	<%@ include file="/header.jsp" %>
		
		<div class="contents">
		<%
		ArrayList<Term> myst = (ArrayList<Term>)request.getAttribute("myst");
      	request.setAttribute("myst", myst);
      	int i=0;
		if(!myst.isEmpty()) { %>
			<div id="listWrapper">
				<h1>보관함</h1>
				<table id="table">
          				<tr><th>번호</th><th>용어</th><th>카테고리</th><th>저장 날짜</th><th>조회수</th><th>등록자</th></tr>
				<% for(i = 0; i < myst.size(); i++){
					Term t = myst.get(i);	%>
					<tr><form action="connect.do" method="put">
						 	<input type="hidden" name="term" value="<%=t.getTerm() %>">
						 	<td><%= i+1%></td>
						 	<td><input type="submit" name="term" value="<%=t.getTerm() %>"/></td>
							<td><input type="submit" name="term" value="<%=t.getTermcate() %>"/></td>
							<td><%=t.getTermdate() %></td>
							<td><%=t.getTermhits() %></td>
							<td><%=t.getTermmem() %></td>
					</form></tr>
				<% }
		} else out.print("<br><br><h3>보관함이 비어있음</h3>");%>
        </table>
          	</div>
         </div>
       <%@ include file="/footer.jsp" %>

</div>
</body>
</html>