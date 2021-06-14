<%@page import="cs.term.vo.Request"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/term_req_st.css">
    <title>PT - Request Term</title>
</head>
<body>
<div id="wrap">
   	<%@ include file="/header.jsp" %>
        <div class="contents">
        <%
        ArrayList<Request> allreq = (ArrayList<Request>)request.getAttribute("allreq");
      	request.setAttribute("allreq", allreq);
        ArrayList<Request> myreq = (ArrayList<Request>)request.getAttribute("myreq");
      	request.setAttribute("myreq", myreq);
      	
      	String reqresult = (String)request.getAttribute("reqresult");
      	String reqmsg = (String)request.getAttribute("reqmsg");
      
      	int i=0;
      	%>
      	
        <div id="req_L">
        <%
        if(allreq != null) { %>
				<table id="table_req">
				<caption>모든 요청 목록</caption>
          				<tr>
          				<th>번호</th><th>요청한 용어</th><th>요청 날짜</th>
          				<% if(sessionId != null){%><th>용어 정의</th><%} %>
          				</tr>
				<% for(i = 0; i < allreq.size(); i++){
					Request req = allreq.get(i);	%>
					<tr><form action="connect.do" method="put">
						 	<input type="hidden" name="term" value="<%=req.getReqterm()%>"/>
						 	<td><%= req.getReqid()%></td>
						 	<td><%=req.getReqterm() %></td>
						 	<td><%=req.getReqdate() %></td>
						 	</form>
						 	<% if(sessionId != null){%>
						 	<form action="enroll.jsp" method="put">
						 		<input type="hidden" name="term" value="<%=req.getReqterm()%>"/>
						 	<td><input type="submit" name="enroll" value="등록"/></td>
							</form>
							<%} %>
						</tr>
				<% }
		}else{%>
				<h2>요청 목록 존재하지 않음</h2>
			<% }%>
        </table>
        </div>
        
        <div id="req_R_top">
        	<h2>용어 정의 요청</h2>
        	<form action="plusreq.do" method="put">
        		<input type="text" name="term" maxlength="20"/>
        		<input type="submit" value="요청"/>
        	</form>
        </div>
        
        <div id="req_R_bottom">
        <%
		if(reqresult == null) { %>
				<table id="table_req">
				<caption>나의 요청 목록</caption>
          				<tr><th>번호</th><th>요청한 용어</th><th>요청 날짜</th><th>삭제</th></tr>
				<% for(i = 0; i < myreq.size(); i++){
					Request req = myreq.get(i);	%>
					<tr><form action="reqdelete.do" method="put">
						 	<input type="hidden" name="term" value="<%=req.getReqterm() %>">
						 	<td><%= i+1%></td>
						 	<td><%=req.getReqterm() %></td>
						 	<td><%=req.getReqdate() %></td>
						 	<td><input type="submit" name="delete" value="삭제"/></td>
					</form></tr>
				<% }
		}else{%>
				<h2><%= reqresult%></h2>
				<h3><%= reqmsg%></h3>
		<% }%>
		</table>
          	</div>
      </div>
        
    <%@ include file="/footer.jsp" %>
</div>
</body>
</html>