<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/term_req_st.css">

    <title>PT - Enroll Term</title>
</head>
<body>
    <div id="wrap"> <%@ include file="/header.jsp" %>
    	<% 
    		String term = (String)request.getParameter("term"); 
    	%>
        <div class="contents">
        <form id="enroll" action="enroll.do" method="put">
        <a href="allterm.do">목록</a>  
        
        <%if(term == null){%>
        	<input type="text" name="term" maxlength="20" placeholder="용어를 입력하세요" autofocus required/>  
        <% }else{%> <input type="text" name="term" maxlength="20" value=<%=term %> readonly/>   
        <%} %>

        <select name="cate" required>
    		<option value="">카테고리</option>
    		<option value="web">web</option>
    		<option value="app">app</option>
    		<option value="common">common</option>
    		<option value="기타">기타</option>
		</select>
		
        <a href="main.do">메인</a>
        
          <textarea name="con" required maxlength="1000"></textarea>
          <input type="submit" name="enroll" value="용어 등록">  
      	</form>
        </div>
        
	<%@ include file="/footer.jsp" %>
    </div>
</body>
</html>