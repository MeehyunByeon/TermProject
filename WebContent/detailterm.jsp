<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="cs.term.vo.Term"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/term_req_st.css">
    <title>PT-Programing Term</title>
</head>
<body>
	<%	
		String term = (String)request.getAttribute("term");
		String termcon = (String)request.getAttribute("termcon");
		boolean yn = (boolean)request.getAttribute("yn");
	%>
    <div id="wrap"> <%@ include file="/header.jsp" %>
        <div class="contents">
        <a href="termlist.jsp">목록</a>  <h1><%=term%></h1>    <a href="main.do">메인</a>
        <article id="detail">
            <textarea cols="20" readonly><%=termcon%></textarea>
          </article>
          <form id="inst" action="store.do" method="put">
        	<%if(yn == true){ %>
        		<input type="hidden" name="sterm" value="cancle">
        		<input type="submit" name="store" value="저장 취소">
            <%}else{%>
              	<input type="hidden" name="sterm" value="<%=term%>">
              	<input type="submit" name="store" value="내 보관함에 담기">
      		<%}%>        
      		</form>
        </div>
        
	<%@ include file="/footer.jsp" %>
    </div>
</body>
</html>