<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook Logout</title>
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
				로그아웃 하시겠어요?
			</div>
			<div class="loginForm">
				<form method="post" action="./logout">
					<div>
						<div>
							<img class="memberIcon" alt="member icon" src="/Team4_Project/img/profile_img.png">
						</div>
						<div id='memberDiv'>${sessionScope.member.full_name} 님</div>
					</div>
					<div class="line"></div>
					<div class="loginDiv">
						<input class="loginButton" type="submit" name="logout" value="로그아웃">
					</div>
					<div class="findPwDiv">
						<a class="findPw" onclick='history.back();'>취소</a>
					</div>
				</form>
			</div>
		</div>	
	</div>
	
</body>
</html>