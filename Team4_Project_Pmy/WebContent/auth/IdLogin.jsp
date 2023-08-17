<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook ID Login</title>
	<script type="text/javascript">
		function failedPwd(){
			var failedPwdObj = document.getElementById('failedPwd');
			failedPwdObj.innerHTML = '<p>입력된 비밀번호가 올바르지 않습니다. 비밀번호를 잊으셨나요?</p>';
		}
	</script>
</head>
<body>
	
	<div class="header">
		<div class="loginMain">
			<div>
				<img class="logo" href="" alt="Facebook Logo" src="../img/face_logo.png">
			</div>
			<div class="loginForm">
				<form method="post" action="./login">
					<div class="fbLogin">
						<div>
							<div>
								<img class="memberIcon" alt="member icon" src="/Team4_Project/img/profile_img.png">
							</div>
							<div id='memberDiv'>${memberDto.full_name}으로 로그인</div>
						</div>
						${memberDto.email} · 회원님이 아닌가요?
					</div>
					<div class="loginDiv">
						<input class="loginInput" type="password" name="password" placeholder="비밀번호"
							aria-label="비밀번호">
						<input type="hidden" name="email" value="${memberDto.email}">
					</div>
					
					<div id='failedPwd' style="text-align: left;">
					</div>
					
					<div class="loginDiv">
						<button class="loginButton" type="submit" name="login">
							로그인
						</button>
					</div>
					<div class="loginDiv">
						<button class="loginButton" type="button" name="login">
							다른 방법 시도
						</button>
					</div>
					<div class="findPwDiv">
						<a class="findPw" href="./findMyAccount">계정을 잊으셨나요?</a>
					</div>
				</form>
			</div>
		</div>	
	</div>
	
	<c:if test="${not empty requestScope.failedPwd}">
	    <script>
			failedPwd();
	    </script>
	</c:if>
	
</body>
</html>