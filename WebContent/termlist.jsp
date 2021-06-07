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

        <div id="contents">
        <form>
          <input id="researchText" type="text" name="research">
          <input id="researchSubmit" type="submit" value="검색"></input>
        </form>
        </div>
        
        <%@ include file="/footer.jsp" %>

    </div>
</body>
</html>