<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook Login Fail</title>
	<script type="text/javascript">
		function emailNotFound(){
			var emailNotFoundObj = document.getElementById('emailNotFound');
			emailNotFoundObj.innerHTML = '입력하신 이메일 주소 또는 휴대폰 번호가 계정에 연결되지 않았습니다'
				+ '.<b>회원님의 계정을 찾아서 로그인하세요.</b>';
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
						Facebook에 로그인
					</div>
					<div class="loginDiv">
						<input class="loginInput" type="email" name="email" placeholder="이메일"
							aria-label="이메일">
					</div>
					<div>
						입력하신 이메일 주소 또는 휴대폰 번호가 계정에 연결되지 않았습니다.<b>회원님의 계정을 찾아서 로그인하세요.</b>
					</div>
					<div class="loginDiv">
						<input class="loginInput" type="password" name="password" placeholder="비밀번호"
							aria-label="비밀번호">
					</div>
					<div class="loginDiv">
						<button class="loginButton" type="submit" name="login">
							로그인
						</button>
					</div>
					<div class="findPwDiv">
						<a class="findPw" href="./findMyAccount">비밀번호를 잊으셨나요?</a>
					</div>
				</form>
			</div>
		</div>	
	</div>
	
	<c:if test="${not empty requestScope.emailNotFound}">
	    <script>
	    emailNotFound();
	    </script>
	</c:if>
	
</body>
</html>