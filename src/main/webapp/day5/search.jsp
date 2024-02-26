<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1 - 상품</title>
<link rel="stylesheet" href="assets/css/customers.css">
</head>
<body>
	<h3>상품 조회 - day3 products.jsp에 검색기능 추가</h3>
	<div class="search">
	<!-- form action 이 없을 때 동작은 자기자신 url 입니다.  method 기본값은  GET -->
	<form action="">
		<select name="category">
			
			<option value="" >카테고리 </option>
			<c:forEach items="${cateList }" var="cate">
				<option value="${cate.code}" ><c:out value="${cate.name }"/> </option>
			</c:forEach>
		</select>
		<input type="text" name="keyword" placeholder="상품명 검색어 입력하세요"  value="${keyword}">	
		<span style="padding-left: 10px;">가격대별 </span>
		<input type="text" name="from" placeholder="10000" value="${from}"><b>~</b>	
		<input type="text" name="to" placeholder="50000" value="${to}">	
		
		<button type="submit">조회</button>
		<button id="searchAll" type="button" onclick="location.href='search.cc'">전체보기</button>
	</form>
</div>
		
		<hr>
		<ul>
		<!-- list 이름의 애트리뷰를 대상으로 합니다. : 애트리뷰트 저장은 서블릿에서 합니다.  -->
		<c:forEach items="${list}" var="vo" varStatus="status">
			<li>
				<ul class ="row">
					<li><c:out value="${status.index +1}" /></li>
					<li><c:out value="${vo.pcode}" /></li> 
					<li><c:out value="${vo.category}" /></li>
					<li><c:out value="${vo.pname}" /></li>
					<li style ="text-align: right;">
						<fmt:formatNumber value="${vo.price}"></fmt:formatNumber>
						
					</li>  
					
				</ul>
			</li>
		</c:forEach>
		</ul>
	  	<script type="text/javascript">
		// js 파일에서는 서버 애트리뷰트를 가져올 수 없습니다. 
		//		jsp  파일안에 있는 script 태그에서만 가능합니다. 
			const temp = '${cate}'
		</script>  
		<!--  temp 변수 값은 search.js 와 공유합니다. -->
		<script type="text/javascript" src="assets/js/search.js"></script>
</body>
</html>