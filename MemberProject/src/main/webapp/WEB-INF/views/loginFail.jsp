<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp"/>

<div class="container">
	<div class="col-lg-6">

		<!-- Basic Card Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">로그인 실패</h6>
			</div>
			<div class="card-body">
				이메일 또는 암호가 맞지 않습니다!<br />
				5초 후, 다시 로그인 화면으로 이동합니다.
				&nbsp;&nbsp;
				<a href="login">(지금 바로 이동하기)</a>
			</div>
		</div>

	</div>
</div>

<script>
	setTimeout( function() { window.location='login'; }, 5000 );
</script>

<jsp:include page="./include/footer.jsp"/>