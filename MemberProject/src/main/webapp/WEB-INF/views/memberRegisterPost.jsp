<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./include/header.jsp" />

<title>회원가입완료</title>
</head>
<body>
${member.mname}회원가입완료
<a href="list">리스트</a>
<jsp:include page="./include/footer.jsp" />