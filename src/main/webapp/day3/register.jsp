<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<link rel="stylesheet" href="/assets/css/register.css">
<!-- 서블릿으로 화면을 보여 줄때에는 ???  -->
</head>
<body>
  <div class="contents-wrap">
  <h3 style="text-align:center;">고객 등록</h3>
  <hr>
          <form action="register.cc" method="post">
            <ul class="join-wrap">
              <li>아이디</li>
              <li>
                <input class="id-input"  name="userid" type="text"
                  placeholder="아이디를 입력해 주세요." />
              </li>
              <!-- <li>비밀번호 <label>(영문 대/소문자, 특수문자를 포함 10-20자로 입력해주세요.)</label> <br><label>사용가능 특수문자 : !@#$%^&* </label></li>
              <li><input name="password" type="password" placeholder="비밀번호를 입력해 주세요." /></li>
              <li>비밀번호 확인</li>
              <li><input name="password2" type="password" placeholder="비밀번호를 다시 한번 입력해 주세요." /></li> -->
              <li>이름</li>
              <li><input name="name" type="text" placeholder="이름" /></li>
              <li>이메일</li>
              <li><input  name="email" type="text" placeholder="이메일을 입력해 주세요." /></li>
              <li>나이</li>
              <li><input  name="age" type="text" placeholder="나이를 입력하세요" /></li>
            </ul>
            <button class="join-btn" >회원가입</button>
          </form>
        </div>
  <script src="assets/js/script.js"></script>
</body>
</html>