<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../log.css" rel="stylesheet" type="text/css">
	<title>Facebook Login Fail</title>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	
	<div>
		<div class="loginMain">
			<div>
				<img class="logo" href="" alt="Facebook Logo" src="../img/face_logo.png">
			</div>
			<div class="loginForm">
				<form>
					<div class="fbLogin">
						Facebook에 로그인
					</div>
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
				</form>
			</div>
		</div>	
	</div>
	
</body>
</html>