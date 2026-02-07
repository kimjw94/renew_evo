<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/loginPage.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/font.css'/>">
</head>
<body>
	<div class="loginPage-container">
		<header class="loginPage-header">
			<div class="loginPage-header-bar">
				<h2 class="loginPage-title">로그인/회원가입</h2>
			</div>
		</header>

		<div class="login-content-box">
			<div class="login-logo-box">
				<div class="login-content-logo">EVO</div>
				<div class="login-content-phrase">Everything in one</div>
			</div>
			
			<div class="login-form">
			<form action="/loginProc" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<input type="text" name="username" placeholder="아이디"> 
				<input type="password" name="password" placeholder="비밀번호"> 
				
				
				<button class="login-btn" type=submit>로그인</button>
			</form>
			
			<div class="redirect-btn-box">
				
				
			</div>
			</div>
		</div>
	</div>
</body>
</html>