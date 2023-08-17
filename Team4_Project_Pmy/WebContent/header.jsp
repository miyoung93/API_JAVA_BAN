<!-- header.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="/Team4_Project/css/header-styles.css">
  <link href="/Team4_Project/css/style.css?after" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<div>
			<div id='logoDiv'>
				<img class="logo" id='logo' alt="Facebook Logo" src="/Team4_Project/img/face_logo.png">
			</div>
			
			<div id='memberBox'>
				<div>
					<div>
						<img class="memberIcon" alt="member icon" src="/Team4_Project/img/profile_img.png">
					</div>
					<div id='memberDiv'>${sessionScope.member.full_name}</div>
				</div>
				
				<div class='hrDiv'>
					<hr>
				</div>
				
				<div>
					<div>
						<img class="logoutIcon" alt="logout icon" src="/Team4_Project/img/logout.png">
					</div>
					<a id='logoutA'href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
				</div>
			</div>
		</div>
	</header>
</body>
</html>