<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1-INDEX</title>
</head>
<body>
	<ul>
		<li><a href="first.cc">서블릿</a></li>
		<li><a href="join.html"></a>html</li>
		<li><a href="day2/13_jdbc_jstl.jsp">jsp</a></li>
	
	</ul>
	<!-- url이 1.  ( .html, .jsp, .aspx, .php ) 로 끝나면 파일형식을 지정합니다. 
												ㄴ 특정 파일이 요청을 처리합니다.
			   2. ( .do , .tamll, .cc )	   로 끝나면 임의의 확장자 (파일형식 x)
			   									ㄴ 자바 클래스가 요청을 처리합니다.(서틀릿)
			   3.  최근에는 URL 에 확장자가 없음.
	-->	
</body>
</html>