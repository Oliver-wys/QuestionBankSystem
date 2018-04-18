<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/jquery.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/loadingpage.js"></script>
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/css/loadingpage.css">
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap/css/bootstrap.css">
<title>Loading Page</title>
</head>
<body>
	<div id="container">
		<div id="head">
			<div id="head-img"></div>
			<div id="head-text">校园题库管理管理系统</div>
		</div>
		<div id="center">
			<div id="center-box">
				<div id="box-left"></div>

				<div id="box-right">
					<!--<div id="loading-text" >请登录</div>-->
					<div id="formbox">
						<form>
							<div class="form-group">
								<label for="account">账号</label> <input type="text"
									class="form-control" id="account" placeholder="账号">
							</div>
							<div class="form-group">
								<label for="password">密码</label> <input
									type="password" class="form-control" id="password"
									placeholder="密码">
							</div>

							<div class="checkbox">
								<label> <input type="checkbox"> 记住我
								</label>
							</div>
							<button type="submit" class="btn btn-primary btn-change ">登陆</button>
						</form>
					</div>

				</div>
			</div>

		</div>

		<div id="bottom"></div>
	</div>

</body>
</html>