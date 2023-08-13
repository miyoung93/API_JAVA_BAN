<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../log.css" rel="stylesheet" type="text/css">
	<title>Facebook Login</title>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	
	<div class="loginMain">
		<div>
			<div>
				<img class="logo" href="" alt="Facebook Logo" src="../img/face_logo.png">
			</div>
			<div class="introduce">
				Facebook에서 전세계에 있는 친구,
				<br>
				가족, 지인들과 함께 이야기를 나눠보
				<br>
				세요.
			</div>
			<br>
			<div class="loginForm">
				<form method="post" action="./login">
					<div class="loginDiv">
						<input class="loginInput" type="email" name="email" placeholder="이메일 또는 전화번호"
							aria-label="이메일 또는 전화번호">
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
						<a class="findPw" href="">비밀번호를 잊으셨나요?</a>
					</div>
					<div class="line">
					</div>
					<div class="loginDiv">
						<button class="createAccount" type="submit" name="join">
							새 계정 만들기
						</button>
					</div>
				</form>
			</div>
		</div>	
	</div>
	
</body>
</html>