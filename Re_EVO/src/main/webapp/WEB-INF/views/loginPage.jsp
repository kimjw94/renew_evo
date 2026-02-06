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
</head>
<body>
	<div class="loginPage-container">
		<header class="loginPage-header">
			<div class="loginPage-title">로그인/회원가입</div>
		</header>

		<div class="login-content-box">
			<div class="loginPage-title">E V O</div>
			<form action="/loginProc" method="post">


				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>
</body>
</html>