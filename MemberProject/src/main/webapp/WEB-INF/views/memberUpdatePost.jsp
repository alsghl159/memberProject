<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./include/header.jsp" />
<h1>update 결과</h1>
<b>정상적으로 수정되었습니다.</b>
<a href="list">리스트로 이동</a>
<script>
	setTimeout( function(){window.location='list';},5000);
</script>

<jsp:include page="./include/footer.jsp" />