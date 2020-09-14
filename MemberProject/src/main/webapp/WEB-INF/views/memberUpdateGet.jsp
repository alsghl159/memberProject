<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <include page="./include/header.jsp" />
<h1>회원 수정</h1>
<form action='update' method='post'>
번호:<input type='text' name='mno' value='${member.mno}' readonly><br>
이름:<input type='text' name='mname' value='${member.mname}'><br>
이메일:<input type='text' name='email'value='${member.email}'><br>
암호:<input type='password' name='pwd'value='${member.pwd}'><br>
가입일:<fmt:formatDate pattern='yyyy-MM-dd' value='${member.cre_date}'/><br>
<input type='submit' value='추가'>
<input type='reset' value='취소'>
<input type='button' onclick='loaction.href=List' value='리스트로'>
</form>
<include page="./include/footer.jsp" />