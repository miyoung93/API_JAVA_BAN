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
					내 계정 찾기
				</div>
				<div class="line"></div>
				<div>계정을 검색하려면 이메일 주소를 입력하세요.</div>
				<div class="loginDiv">
					<input class="loginInput" type="email" name="email" placeholder="이메일"
						aria-label="이메일 ">
				</div>
				<div class="line"></div>
				<div class="findPwDiv">
					<button type="reset" name="cancle">취소</button>
					<button type="search" name="search">검색</button>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>