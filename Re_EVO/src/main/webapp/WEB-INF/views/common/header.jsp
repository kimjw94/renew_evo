<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="header">
	<div class="header-title" align="center">
		<c:choose>
			<c:when test="${not empty loginUser }">
				<div >
					<a class="header-login" href="<c:url value='/myPage'/>">내 정보</a>
				</div>

			</c:when>
			<c:otherwise>
				<div>
				<a class="header-login" href="<c:url value='/login'/>">로그인</a>
				</div>
			</c:otherwise>
			
		</c:choose>
	</div>
</header>
