<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook Login</title>
</head>
<body>
	
	<div class="header">
		<div class="loginMain">
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
						<input class="loginInput" type="email" name="email" placeholder="이메일"
							aria-label="이메일 ">
					</div>
					<div class="loginDiv">
						<input class="loginInput" type="password" name="password" placeholder="비밀번호"
							aria-label="비밀번호">
					</div>
					<div class="loginDiv">
						<input class="loginButton" type="submit" name="login" value="로그인">
					</div>
					<div class="findPwDiv">
						<a class="findPw" href="./findMyAccount">비밀번호를 잊으셨나요?</a>
					</div>
					<div class="line">
					</div>
					<div class="loginDiv">
						<input class="createAccount" type="button" name="join" value="새 계정 만들기"
							onclick='location.href="../join/join2.jsp"'>
					</div>
				</form>
			</div>
		</div>	
	</div>
	
</body>
<script type="text/javascript">
	
</script>
</html>