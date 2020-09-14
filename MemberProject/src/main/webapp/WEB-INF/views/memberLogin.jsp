<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp"/>
<form id="memberLogin" action="login" method='post'>
이메일:<input type='text' name='email'>
비밀번호:<input type='password' name='pwd'>
<input type='submit' value='확인'>
<input type='reset' value='취소'>

</form>
<jsp:include page="./include/footer.jsp"/>