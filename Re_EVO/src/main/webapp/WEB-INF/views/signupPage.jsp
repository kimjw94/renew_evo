<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/font.css'/>">
</head>

<body>
	<div class="signupPage-container">

		<header class="signupPage-header">
			<h2 class="signupPage-title">회원가입 페이지</h2>
		</header>
		<div class="signup-content-box">
			<form action="singupProc" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<input name="username" type="text" placeholder="아이디">
					
				



			</form>
		</div>
	</div>
</body>
</html>