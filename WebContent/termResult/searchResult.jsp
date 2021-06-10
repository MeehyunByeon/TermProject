<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
		ArrayList<Term> researchTerms = (ArrayList<Term>)request.getAttribute("researchTerms");
		request.setAttribute("researchTerms", researchTerms);
      	int i=0;
		if(!researchTerms.isEmpty()) { %>
			<div id="listWrapper">
				<table id="table">
          				<tr><th>번호</th><th>용어</th><th>카테고리</th><th>날짜</th><th>조회수</th><th>등록자</th></tr>
				<% for(i = 0; i < researchTerms.size(); i++){
					Term term = researchTerms.get(i);	%>
					<tr><form action="connect.do" method="put">
						 	<input type="hidden" name="term" value="<%=term.getTerm() %>">
						 	<td><%= i+1%></td>
						 	<td><input id="" type="submit" name="term" value="<%=term.getTerm() %>"/></td>
							<td><input id="" type="submit" name="term" value="<%=term.getTermcate() %>"/></td>
							<td><%=term.getTermdate() %></td>
							<td><%=term.getTermhits() %></td>
							<td><%=term.getTermmem() %></td>
					</form></tr>
				<% }
		} else out.print("<h3>입력하신 용어를 확인해주세요</h3>");%>
        </table>
        <form id="inst" action="allterm.do" method="post">
            	<input type="submit" value="용어 목록">
            </form>
            <form id="inst" action="storage.do" method="post">
           		<input type="submit" value="보관함">
          	</form>
          	</div>
        
        <%@ include file="/footer.jsp" %>
    </div>
</body>
</html>