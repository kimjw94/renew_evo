<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<script>
const contextPath = "${pageContext.request.contextPath}";
</script>
<title>Insert title here</title>
</head>
<body>
<div class="admin-header"> 관리자 페이지
<a href="<c:url value='/'/>">Home</a> 
<a href="<c:url value='/admin/requestSellerChk'/>">판매자 요청 승인/거절</a>



</div>

<div class="admin-contents">
<jsp:include page="${cp}"/>
</div>

<div class="admin-footer"></div>



</body>
</html>