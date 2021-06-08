<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/PT.css">
</head>
<body>
    	<header>
        <div id="header">
      	<h1><a href="main.do">P r o g r a m i n g T e r m</h1>
      	<h3><em>For Better Programing</em></a></h3>
      	</div> 
    	</header>

        <div id="nav">
        <ul>
   	    	<li><a href="allterm.do">용어</a></li>
        	<li><a href="storage.do">보관함</a></li>
        	<li><a href="request.do">요청</a></li>
        	<%String sessionId = (String)request.getSession().getAttribute("sessionId"); 
				if(sessionId != null){	        	
        	%>
        		<li><a href="myinfo.do">MY</a></li>
        	<%}else{ %>
        		<li><a href="login.jsp">MY</a></li>
        	<%} %>
      	</ul>
      	</div>
</body>
</html>