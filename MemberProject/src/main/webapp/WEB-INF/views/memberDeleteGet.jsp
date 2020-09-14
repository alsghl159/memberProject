<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp"/>
<script>
function loadFnc() {
   var txt;
   var question=confirm("${member.mname}님의 회원정보를 삭제하시겠습니까?");
   if(question==true) {
      document.getElementById("memberDelete").submit();
      //document.forms["success"].submit();
   } else {
      txt="${member.mname}님의 회원정보 삭제를 취소하였습니다.";
       document.getElementById("cancel").innerHTML=txt;
   }
  
}
window.onload=loadFnc;
</script>
<form id="memberDelete" action="delete" method="post">
<input type='text' name='mno' value='${member.mno }'>
</form>
<p id="cancel"></p>
<br>
<input type="button" onclick="location.href='list'" value="회원목록">
<jsp:include page="./include/footer.jsp"/>