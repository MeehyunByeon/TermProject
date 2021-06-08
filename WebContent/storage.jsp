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
		<%
		ArrayList<Term> myst = (ArrayList<Term>)request.getAttribute("myst");
      	request.setAttribute("myst", myst);
      	int i=0;
		if(!myst.isEmpty()) { %>
			<div id="listWrapper">
				<table id="table">
          				<tr><th>번호</th><th>용어</th><th>카테고리</th><th>날짜</th><th>조회수</th></tr>
				<% for(i = 0; i < myst.size(); i++){
					Term t = myst.get(i);	%>
					<tr><form action="connect.do" method="put">
						 	<input type="hidden" name="term" value="<%=t.getTerm() %>">
						 	<td><%= i+1%></td>
						 	<td><input id="" type="submit" name="term" value="<%=t.getTerm() %>"/></td>
							<td><input id="" type="submit" name="term" value="<%=t.getTermcate() %>"/></td>
							<td><input id="" type="submit" name="term" value="<%=t.getTermdate() %>"/></td>
							<td><input id="" type="submit" name="term" value="hits"/></td>
					</form></tr>
				<% }
		} else out.print("<h3>Error</h3>");%>
        </table>
          	</div>
        
       <%@ include file="/footer.jsp" %>

    </div>
</body>
</html>