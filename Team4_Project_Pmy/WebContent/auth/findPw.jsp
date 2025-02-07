<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook Find Password</title>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	
	<div class="header">
		<div class="loginForm">
			<form method="post" action="./findPw">
				<div>
					비밀번호 재설정
				</div>
				<div class="line"></div>
				<div>어떤 방법으로 비밀번호를 받으시겠어요?</div>
				<div class="loginDiv">
					<label><input type="radio" name="pwd" id="option1" value='option1'>기존 비밀번호 안내 받기</label>
					<label><input type="radio" name="pwd" id="option2" value='option2'>비밀번호를 입력하여 로그인</label>
				</div>
				<div class="line"></div>
				<div class="findPwDiv">
					<!-- 누르면 내 계정 찾기로 이동 -->
					<a href="./findMyAccount">회원님이 아닌가요?</a>
					<input type="submit" name="continue" value="계속하기">
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>