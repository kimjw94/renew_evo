<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>판매자 등록 요청 관리</h2>

<!-- 상태 필터 -->
<div style="margin-bottom:15px;">

<a href="<c:url value='/admin/requestSellerChk?status=all'/>">전체</a> |
<a href="<c:url value='/admin/requestSellerChk?status=Request'/>">요청</a> |
<a href="<c:url value='/admin/requestSellerChk?status=Approved'/>">승인</a> |
<a href="<c:url value='/admin/requestSellerChk?status=Rejected'/>">거절</a>

</div>


<table border="1" width="100%">
<thead>
<tr>
<th>요청번호</th>
<th>상호명</th>
<th>대표자</th>
<th>사업자번호</th>
<th>전화</th>
<th>이메일</th>
<th>요청일</th>
<th>상태</th>
<th>관리</th>
</tr>
</thead>

<tbody>

<c:forEach var="req" items="${list}">

<tr>

<td>${req.sellerReqNo}</td>

<td>${req.businessName}</td>

<td>${req.businessOwner}</td>

<td>${req.businessNumber}</td>

<td>${req.businessTel}</td>

<td>${req.businessEmail}</td>

<td><fmt:formatDate value="${req.requestDate}" pattern="yyyy-MM-dd"/></td>

<td>${req.statusName}</td>

<td>

<c:if test="${req.requestStatus eq 'Request'}">

<button>승인</button>
<button>거절</button>

</c:if>

<c:if test="${req.requestStatus ne 'Request'}">

처리완료

</c:if>

</td>

</tr>

</c:forEach>

</tbody>

</table>


<!-- 페이징 -->

<div style="margin-top:20px;">

<c:if test="${pageMaker.prev}">
<a href="<c:url value='/admin/requestSellerChk?page=${pageMaker.startPage-1}&status=${status}'/>">
이전
</a>
</c:if>

<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">

<a href="<c:url value='/admin/requestSellerChk?page=${num}&status=${status}'/>">
${num}
</a>

</c:forEach>

<c:if test="${pageMaker.next}">
<a href="<c:url value='/admin/requestSellerChk?page=${pageMaker.endPage+1}&status=${status}'/>">
다음
</a>
</c:if>

</div>

</body>
</html>