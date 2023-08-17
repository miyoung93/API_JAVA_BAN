<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Team4_Project/css/log.css" rel="stylesheet" type="text/css">
	<title>Facebook Find My Account</title>
	
	<script type="text/javascript">
		function failedLogin(){
			var failedLoginObj = document.getElementById('failedLogin');
			failedLoginObj.innerHTML = '<p>검색 결과 없음</p>'
				+ '<p>검색하신 내용을 찾을 수 없습니다. 다른 정보를 이용하여 다시 검색해주세요.</p>';
		}
	</script>
</head>
<body>
	
	<div class="header">
		<div class="loginForm">
			<form method="post" action="./findMyAccount">
				<div>
					내 계정 찾기
				</div>
				<div class="line"></div>
				
				<div id='failedLogin' style="text-align: left;">
					
				</div>
				
				<div>계정을 검색하려면 이메일 주소를 입력하세요.</div>
				<div class="loginDiv">
					<input class="loginInput" type="email" name="email" placeholder="이메일"
						aria-label="이메일">
				</div>
				<div class="line"></div>
				<div class="findPwDiv">
					<input type="button" name="cancel" value="취소" onclick='location.href="./login"'>
					<input type="submit" name="search" value="검색">
				</div>
			</form>
		</div>
	</div>
	
	<c:if test="${not empty requestScope.failedLogin}">
	    <script>
			failedLogin();
	    </script>
	</c:if>
	
</body>


</html>

