<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/loginPage.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/font.css'/>">
</head>
<body>
	<div class="loginPage-container">
		<header class="loginPage-header">
			<h2 class="loginPage-title">로그인/회원가입</h2>
		</header>

		<div class="login-content-box">
			<div class="login-logo-box">
				<div class="login-content-logo">EVO</div>
				<div class="login-content-phrase">Everything in one</div>
			</div>

			<div class="login-form">
				<form action="<c:url value='/loginProc'/>"  method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="text" name="username"
						placeholder="아이디"> <input type="password" name="password"
						placeholder="비밀번호">


					<button class="login-btn" type=submit>로그인</button>
				</form>
			</div>

			<div class="login-forward-signup">
				<a class="signup_btn" href="<c:url value='/signup'/>"> 회원가입 하기 </a>
			</div>
			<div class="login-forward-find">
				<a class="findId_a" href="<c:url value='/findId'/>">아이디 찾기</a> <a
					class="findPassword_a" href="<c:url value='/findPassword'/>">비밀번호
					찾기</a>
			</div>

			<footer class="loginPage-footer">
				<a href="<c:url value='/non_UserOrder'/>" class="non-user-order-btn"> 비회원 주문 조회</a>
			
			</footer>



		</div>
	</div>
</body>
</html>