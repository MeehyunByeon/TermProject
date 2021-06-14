<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="cs.term.vo.Term"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/term_req_st.css">
    <title>PT - Detail Term</title>
</head>
<body>
	<%	
		String term = (String)request.getAttribute("term");
		Term terms = (Term)request.getAttribute("terms");
		String yn = (String)request.getAttribute("rr");
	%>
    <div id="wrap"> <%@ include file="/header.jsp" %>
        <div class="contents">
        <a href="allterm.do">목록</a>  <h1>[ <%= term%> ]</h1>  <a href="main.do">메인</a>
        <h2><%= terms.getTermcate()%></h2>
            <textarea cols="20" readonly><%= terms.getTermcon()%></textarea>
          
          <form id="inst" action="store.do" method="put">
          	<input type="hidden" name="term" value="<%= term%>">
          	
        	<%if(yn != null){ %>
        		<input type="hidden" name="choice" value="cancle">
        		<input type="submit" value="저장 취소">
            <%}else{%>
              	<input type="submit" name="choice" value="내 보관함에 담기">
      		<%}%>        
      		</form>
        </div>
        
	<%@ include file="/footer.jsp" %>
    </div>
</body>
</html>