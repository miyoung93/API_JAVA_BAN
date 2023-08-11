<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		img{
			width: 301.06px;
			height: 106px;
			margin: -15px;
		}
		
		a{
			text-decoration: none;
			color: #1877F2;
			font-size: 14px;
		}
		
		input:focus{
			outline:1px solid #1877F2;
		}
		
		a:hover {
    		text-decoration: underline;
		}
	
	</style>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	
	<body style="background-color: #F0F2F5;">
	<div>
		<div style="text-align: center;">
			<div>
				<img href="" alt="Facebook Logo" src="./img/face_logo.png">
			</div>
			<div style="background-color: #FFFFFF; padding-bottom: 24px; padding-top: 10px;
				border: none; border-radius: 8px; width: 400px; margin: 0px auto;">
				<form>
					<div style="font-size: 18px;">
						Facebook에 로그인
					</div>
					<div style="width: 370px; color: #1CLE21; margin: auto;
					padding: 6px;">
						<input type="email" name="email" placeholder="이메일 또는 전화번호"
							aria-label="이메일 또는 전화번호" style="border-radius: 6px;
							font-size: 17px; width: 330px; height: 22px; vertical-align: middle;
							border: 1px solid #DDDFE2; color: #1D2129; padding: 14px 16px;">
					</div>
					<div style="font-size: 13px; color: #F02849; text-align: left; margin-top: 8px;
						line-height: 16px; padding: 0px 17px;">
						입력하신 이메일 주소 또는 휴대폰 번호가 계정에 연결되지 않
						<br>
						았습니다.
						<a href=""> 회원님의 계정을 찾아서 로그인하세요.</a>
					</div>
					<div style="width: 370px; color: #1CLE21; margin: auto; padding: 6px;">
						<input type="password" name="password" placeholder="비밀번호"
							aria-label="비밀번호" style="border-radius: 6px;
							font-size: 17px; width: 330px; height: 22px; vertical-align: middle;
							border: 1px solid #DDDFE2; color: #1D2129; padding: 14px 16px;">
					</div>
					<div style="width: 370px; padding-top: 6px; margin: auto;">
						<button type="submit" name="login" style="background-color: #1877F2;
							border: none; border-radius: 6px; padding: 0px 16px; width: 364px;
							color: #FFFFFF; font-weight: bold; height: 48px; vertical-align: middle;
							font-size: 20px; cursor: pointer;">
							로그인
						</button>
					</div>
					<div style="margin-top: 16px;">
						<a href="">비밀번호를 잊으셨나요?</a>
					</div>
				</form>
			</div>
		</div>
		
	</div>
	
	
</body>
</html>