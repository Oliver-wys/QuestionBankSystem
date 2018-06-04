<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/jquery.min.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/login.js"></script>
<link rel="stylesheet" href="/QuestionBankSystem/assets/css/login.css">
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap/css/bootstrap.css">
<title>Login Page</title>
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
					<div id="loading-text-box">
						<div id="text-null" class="loading-text" style="display: none">
							<span>账号或密码不能为空</span>
						</div>
						<c:if test="${param.error != null}">
							<div id="text-error" class="loading-text" style="display: none">
								<span>账号或密码错误</span>
							</div>
						</c:if>
					</div>
					<div id="formbox">
						<form action="${loginProcessingUrl}" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<div class="form-group">
								<label for="username">账号</label> <input type="text"
									class="form-control" id="username" name="username"
									placeholder="账号">
							</div>
							<div class="form-group">
								<label for="password">密码</label> <input type="password"
									class="form-control" id="password" name="password"
									placeholder="密码">
							</div>
							<button id="submit" class="btn btn-primary btn-change ">登录</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="bottom"></div>
	</div>
</body>
</html>