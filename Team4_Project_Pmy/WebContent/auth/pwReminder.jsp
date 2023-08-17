<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook Password Reminder</title>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	
	<div class="header">
		<div class="loginMain">
			<div>
				<img class="logo" href="" alt="Facebook Logo" src="../img/face_logo.png">
			</div>
			<div class="introduce">
				기존 비밀번호 안내
			</div>
			<div class="loginForm">
				<form method="post" action="./findPw">
					<div>
						${memberDto.full_name}님
					</div>
					<div>
						비밀번호는 ${memberDto.pwd}입니다.
					</div>
					<div class="line"></div>
					<div class="loginDiv">
						<input class="loginButton" type="button" name="move_login" value="로그인창으로 이동" onclick='location.href="./login"'>
					</div>
				</form>
			</div>
		</div>	
	</div>
	
</body>
</html>