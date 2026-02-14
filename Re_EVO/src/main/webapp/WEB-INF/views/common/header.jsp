<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<header class="header">
	<div class="header-left">
		<a class="header-title" href="<c:url value='/'/>"> 
			<span class="brand-title">EVO</span>
			
		</a>
	</div>

	<div class="header-right">
		<sec:authorize access="isAnonymous()">
			<div>
				<a class="header-login" href="<c:url value='/login'/>">로그인</a>
			</div>
		</sec:authorize>

		<!-- 2. 로그인 상태일 때 -->
		<sec:authorize access="isAuthenticated()">
			<div>
				<form id="logoutForm" action="<c:url value='/logout'/>"
					method="post" style="display: none;">
					<sec:csrfInput />
				</form>
				<a class="header-login" href="#"
					onclick="document.getElementById('logoutForm').submit(); return false;">
					로그아웃 </a>
			</div>


		</sec:authorize>

	</div>

</header>
