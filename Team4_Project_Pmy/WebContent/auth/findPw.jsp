<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="../log.css" rel="stylesheet" type="text/css">
	<title>Facebook Find ID</title>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	
	<div>
		<div class="loginForm">
			<form>
				<div>
					비밀번호 재설정
				</div>
				<div class="line"></div>
				<div>어떤 방법으로 비밀번호 재설정 코드를 받으시겠어요?</div>
				<div class="loginDiv">
					<label><input type="radio" name="pwd">SMS로 코드 받기</label>
					<label><input type="radio" name="pwd">비밀번호를 입력하여 로그인</label>
				</div>
				<div class="line"></div>
				<div class="findPwDiv">
					<!-- 누르면 내 계정 찾기로 이동 -->
					<a type="reset" name="cancle">회원님이 아닌가요?</button>
					<button type="submit" name="search">계속하기</button>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>