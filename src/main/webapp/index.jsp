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
	<!-- html에서 url 지정하는 href 속성값이 /  로 시작하면 컨텍스트 /jsp1 이 사라집니다.
			<li><a href="/customers.cc">고객 전체 조회</li> 일경우 ->->  http://localhost:8088/customers.cc
	 -->
	<hr>
	<h3>TBL_고객 테이블의 데이터 조희/저장 서블릿 테스트 (day3)</h3>
	<h4>GET 방식 요청</h4>
	<p>파라미어값을 UTF-8 인코딩 합니다.</p>
	<ul>
		<li><a href="customers.cc">고객 전체 조회</a></li>
		<li><a href="products.cc">상품(tbl_product) 전체 조회</a></li>
		<li><a href="buys.cc">구매(tbl_buy) 전체 조회</a></li>

	</ul>
	<h4>POST 방식 요청</h4>
	<p>POST 방식 요청은 form 을 이용해서 동작합니다. GET은 파라미터를 URL 로 전달하지만 POST는 HTTP
		프로토콜 메시지 body에 저장하여 요청을 보냅니다. POST는 서버 데이터의 추가 /수정/삭제와 같은 변경작업에 주로
		사용합니다.</p>
	<h5>고객 등록 화면, 고객 등록 입력값 저장 2개의 작업 필요/</h5>
	
	<!--  
		방법	1) 1개의 서블릿에서 ,  doGet, doPost를 구현하기
			2) 2개의 작업 각각 서블릿 만들기 
	-->
	<ul>
		<li>
			<a href="register.cc">고객 등록</a>
		</li>
		<li>	
			<a href="productsReg.cc">상품 등록</a>
		</li>
	<hr>
	</ul>
	<h3>여러가지 URL 형식 테스트(day2)</h3>
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