<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp"/>
<p>삭제가 완료되었습니다.</p><br>
<p>5초후 회원 목록 페이지로 이동합니다. 지금 이동하시려면 버튼 클릭</p>
<input type="button" onclick="location.href='list'" value="목록">
<script>
   setTimeout(function() {window.location='list';}, 5000);
</script>
<jsp:include page="./include/footer.jsp"/>