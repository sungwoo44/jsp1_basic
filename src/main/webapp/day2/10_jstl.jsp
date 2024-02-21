<%@ page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10_jstl and EL</title>
</head>
<body>
	<h3>JSTL 태그라이브러리 테스트</h3>
	<p>기존에 사용하던 jsp의 스크립트릿, 출력식 기호를 대체합니다. 
	why?? 요청처리하는 자바코드와 화면을 구성하는 html 태그를 분리할 때 jsp 파일을 태그형식으로만 작성하기 위해서~~</p>
	
	
	<p>태그 라이브러리는 맨 위 지시자에서 정의하고 사용합니다.EL 기호   는 애트리뷰트 출력할 수 있습니다.</p>
	
	<% String name = "sana"; %>
	<hr>
	<h4>c: 으로 시작하는(prefix) core 태그</h4>
		<!--1. pageContext 영역에 애트리뷰트 이름 age, 값 23 을 저장 -->
		<c:set var="age" value="13"/>
		<!--2.저장된 애트리뷰트 값 출력  -->
		<h5>age: <c:out value="${age}"/></h5>		<!--age 는 애트리뷰트 이름  -->
		<h5>name: <c:out value="${name}"/></h5>		<!--name 은 자바변수 출력 안됨. -->
		<!--3.자바의 if문을 대체하는 태그  -->
		<h5>c:if 테스트</h5>
		<!-- 조건식을 test 속성에 작성. EL 기호안에 씁니다. -->
		<c:if test="${age<20}">
			<div style="color:green">청소년 입니다.</div>
		</c:if>
		<c:if test="${age>=20}">
			<div style="color:red">성인 입니다.</div>
		</c:if>
		
		
		<!--4.if ~else 형식  -->
		<c:set var="age" value="23"/>			<!-- 애트리뷰트 age 값 변경하기 -->
		<c:choose>
			<c:when test="${age<20}">
					<div style="color:green">청소년 입니다.</div>
			</c:when>
			<c:otherwise>
					<div style="color:red">성인 입니다.</div>
			</c:otherwise>
		</c:choose>
			
		
		<!-- 5. for문 -->	
		<h5>c:forEach 테스트</h5>
		<c:forEach var="i" begin="21" end ="30" varStatus="status" step="2">
		<!--  step 기본값 1 -->

		<div>
			 <c:out value="${i}"/>,
			 <c:out value="${i*11}"/>,
			 <!-- varstatus 속성은 for반복 상태를 알수 있는 값을 제공합니다. -->
			 <c:out value="${status.count}"/>,
			 <c:out value="${status.step}"/>
		</c:forEach>
		</div>
		<!-- 6. 자바 객체 활용하기  -->
		<h5>자바 객체 활용하기</h5>
		<% 
				//서블릿을 활용하여 가져올 값이지만 여기서는 직접 정의합니다.
				CustomerVo vo =new CustomerVo("momo22","강모모","momo22@daum.net",29,null);
				//만들어지는 객체를 pageContext scope의 애트리뷰트로 저장합니다.
				// 애트리뷰트 이름 customer, 값은 vo 
				pageContext.setAttribute("customer",vo);
			
		%>
		 <c:out value="${customer}"/>
		 <ul>
		 <!--  객체변수명. getXXX() getter 메소드 사용합니다. 그러나 EL은 
		 	   알아서 getter 동작을 합니다. 객체의 속성 이름을 정확히 작성하기
		 	   			 	
 		-->
 		<!-- 객체의 정의된 속성이름과 정확히 일치하지 않으면 오류~~~  -->
		 	<li>${customer.customId}</li>
		 	<li>${customer.name}</li>
		 	<li>${customer.email}</li>
		 	<li>${customer.age}</li>
		 </ul>
		
</body>
</html>