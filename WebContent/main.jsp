<%@page import="cs.term.vo.Term"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/PT.css">
    <title>PT-Programing Term</title>
</head>
<body>
    <div id="wrap"> <%@ include file="/header.jsp" %>

        <div id="contents">
      <% 
		ArrayList<Term> main = (ArrayList<Term>)request.getAttribute("main");
		if(!main.isEmpty()) { %>
				<% for(int i = 0; i < 6; i++){
					Term term = main.get(i);	%>
						 <article>
						 <div><form action="connect.do" method="put">
							<input id="maints" type="submit" name="<%=term.getTerm() %>" value="<%=term.getTerm() %>"/><br><br>
								<textarea cols="35" rows="8" readonly><%=term.getTermcon() %></textarea>
						 	</form>
          				</div>
          				</article>
				<%	}
			}else {
				out.print("<h3>Error</h3>");
			}
		%>
       	<%@ include file="/footer.jsp" %>
	</div>
   </div>
</body>
</html>