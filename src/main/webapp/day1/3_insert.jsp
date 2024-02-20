<%@page import="project.dao.TblCustomerDao"%>
<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>2번  select 조회 결과 확인과 같이 이번에는 insert 실행해봅자.</p>
<%
	CustomerVo vo = new CustomerVo("sanaa","김사나","sanaa@gmail.com",23,null);
	//dao 생성해서 inser하기
	TblCustomerDao dao = new TblCustomerDao();
	dao.join(vo);
%>

	<h4> CustomerVo 객체</h4>
	
	<table style= "width:500px">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
			<th>가입날짜</th>
		</tr>
		
		<tr style = "align-content: center"> 
			<td><%= vo.getCustomId() %></td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getEmail() %></td>
			<td><%= vo.getAge() %></td>
			<td><%= vo.getReg_date() %></td>
		
		</tr>
	</table>	
	<p>아래 링크로 페이지 이동해서 insert 완료 됫는지 확인해보기</p>
	<a href="2_jdbc.jsp">전체 고객 조회</a>
	</body>
	
</html>
	<!-- 단축키 : ctrl +d 한줄삭제  ctrl + alt + 방향키 (한줄복사)
				alt + 방향키 (줄이동)  ctrl + shift + / (주석)   shift + 엔터 (다음줄 이동)
				ctrl + 스페이스(참조, 임포트 ,자동완성 등...)
	  -->