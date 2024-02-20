<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5_prarm_receive</title>
</head>
<body>
	<h3>4번 url 주소에서 보낸 파라미터를 받아 값을 저장합니다. 활용은 조회할때</h3>
<%
	String name = request.getParameter("name");
	String temp = request.getParameter("age");
	
	
	//아래 if문은 모든 파라미터 값이 전송되었을때만 실행되는 조건식입니다.
	//			ㄴ  실제로는 입력 파라미터는 자바스크립트에서 검사합니다.
	if((name!=null && name.length() !=0)&&(temp!=null &&temp.length()!=0)){
	
	// todo : name, age 값으로 테이블에서 조회하기 & 결과 출력
			// age 는 정수타입으로 변경되어야 한다.
				
		int age= Integer.parseInt(temp);
		
		out.print("<h4>name</h4>");
		out.print(name);
		
		out.print("<h4>age</h4>");
		out.print(age);
	
	}
	else{
		out.print("파라미터 값은 모두 입력하세요.");
	}

%>
</body>
</html>