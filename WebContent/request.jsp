<%@page import="cs.term.vo.Request"%>
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
        ArrayList<Request> allreq = (ArrayList<Request>)request.getAttribute("allreq");
      	request.setAttribute("allreq", allreq);
        ArrayList<Request> myreq = (ArrayList<Request>)request.getAttribute("myreq");
      	request.setAttribute("myreq", myreq);
      	String reqresult = (String)request.getAttribute("reqresult");
      	String reqmsg = (String)request.getAttribute("reqmsg");
      	
      	String path = null;
      	if(sessionId != null) path = "enroll.jsp";
      	else {
      		request.setAttribute("result", "용어 등록을 할 수 없음");
			request.setAttribute("msg", "용어 등록은 회원만 가능하오니 로그인 또는 회원가입을 해주세요.");
      		path = "termResult/toStorageFail.jsp";
      	}
      	int i=0;
      	%>
      	
        <div id="req_L">
        <%
        if(allreq != null) { %>
				<table id="table_req">
				<caption>모든 요청 목록</caption>
          				<tr><th>번호</th><th>요청한 용어</th><th>요청 날짜</th><th>용어 정의</th></tr>
				<% for(i = 0; i < allreq.size(); i++){
					Request req = allreq.get(i);	%>
					<tr><form action=<%=path %> method="put">
						 	<input type="hidden" name="term" value="<%=req.getReqterm()%>"/>
						 	<td><%=req.getReqid() %></td>
						 	<td><%=req.getReqterm() %></td>
						 	<td><%=req.getReqdate() %></td>
						 	<td><input type="submit" name="enroll" value="등록"/></td>
					</form></tr>
				<% }
		}else{%>
				<h2>요청 목록 존재하지 않음</h2>
			<% }%>
        </table>
        </div>
        
        <div id="req_R_top">
        <%
		if(reqresult == null) { %>
				<table id="table_req">
				<caption>나의 요청 목록</caption>
          				<tr><th>번호</th><th>요청한 용어</th><th>요청 날짜</th><th>삭제</th></tr>
				<% for(i = 0; i < myreq.size(); i++){
					Request req = myreq.get(i);	%>
					<tr><form action="reqdelete.do" method="put">
						 	<input type="hidden" name="term" value="<%=req.getReqmem() %>">
						 	<td><%= i+1%></td>
						 	<td><%=req.getReqterm() %></td>
						 	<td><%=req.getReqdate() %></td>
						 	<td><input type="submit" name="reqdelete" value="삭제"/></td>
					</form></tr>
				<% }
		}else{%>
				<h2><%= reqresult%></h2>
				<h3><%= reqmsg%></h3>
		<% }%>
		</table>
          	</div>
        <div id="req_R_bottom">
        	<h2>용어 정의 요청</h2>
        	<form action="req.do" method="put">
        		<input type="text" name="reqterm" maxlength="20"/>
        		<input type="submit" name="req" value="요청"/>
        	</form>
        </div>
      </div>
        
    <%@ include file="/footer.jsp" %>
</div>
</body>
</html>