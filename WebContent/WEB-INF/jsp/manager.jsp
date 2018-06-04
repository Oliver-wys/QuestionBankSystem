<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script type="text/javascript">
	function del(id){
		console.log("id:" + id);
	}
</script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园题库管理系统</title>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/jquery.min.js"></script>
<!-- <script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap/js/bootstrap.bundle.min.js"></script> -->
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap-table/dist/bootstrap-table.css">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap-table/dist/bootstrap-table.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/toastr.min.js"></script>
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/css/toastr.min.css">

<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/manager.js"></script>
<link rel="stylesheet" href="/QuestionBankSystem/assets/css/main.css">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/user-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/academy-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/subject-table.js"></script>


</head>
<body>
	<div id="container">
		<div id="head">
			<div id="head-img"></div>
			<div id="head-text">校园题库管理管理系统</div>
		</div>

		<div id="center">
			<div id="center-box">
				<div id="box-left">
					<div id="user-box">
						<div id="user-img"></div>
						<div id="user-info">
							<p>用户：管理员</p>
							<div id="password-change" class="user-action">
								<a href="#" class="badge badge-dark" data-toggle="modal"
									data-target="#changepassword">修改密码</a>
							</div>
							<div id="logout" class="user-action">
								<a href="./logout" class="badge badge-dark">退出</a>
							</div>
						</div>
					</div>
					<!-- 修改密码modal -->
					<div class="modal fade" id="changepassword" tabindex="-1"
						role="dialog" aria-labelledby="addnewuser" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h3 class="modal-title" id="addnewuser">修改密码</h3>
								</div>
								<div class="modal-body">
									<form>
										<div class="form-group">
											<label for="oldpassword" class="col-form-label"> 原密码:</label>
											<input type="text" class="form-control" id="oldpassword">
											<label for="newpassword" class="col-form-label"> 新密码:</label>
											<input type="text" class="form-control" id="newpassword">
											<label for="confirmpassword" class="col-form-label">
												确认新密码:</label> <input type="text" class="form-control"
												id="confirmpassword">
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">关闭</button>
									<button class="btn btn-primary">确认修改</button>
								</div>
							</div>
						</div>
					</div>


					<div id="menu-box">
						<div class="row" des="user">
							<p>用户管理</p>
						</div>
						<div class="row" des="academy">
							<p>院系管理</p>
						</div>
						<div class="row" des="subject">
							<p>科目管理</p>
						</div>

					</div>
				</div>

				<div id="box-right">

					<div class="des-box" style="display: none">
						<h3 class="des-inf">用户信息</h3>
						<div id="toolbar1" class="btn-group">
							<button id="btn_edit" type="button"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#newuser">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
							</button>
							<button id="btn_delete" type="button"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</div>
						<div class="table-box">
							<table id="user-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar1">
							</table>
						</div>
						<!-- 用户添加modal -->
						<div class="modal fade" id="newuser" tabindex="-1" role="dialog"
							aria-labelledby="addnewuser" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewuser">添加新用户</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 院系名:</label> <select
													class="btn btn-default selectpicker">

												</select>
											</div>
											<div class="form-group">
												<label for="newaccount" class="col-form-label">
													用户账号:</label> <input type="text" class="form-control"
													id="newaccount"> <label for="newpassword"
													class="col-form-label"> 用户密码:</label> <input type="text"
													class="form-control" id="newpassword">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">添加</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 用户删除modal -->
						<div class="modal fade" id="deluser" tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h5 class="modal-title" rowid="0">提示</h5>
									</div>
									<div class="modal-body">
										<h4>是否删除该用户信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 用户批量删除modal -->
						<div class="modal fade" id="delusers" tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h5 class="modal-title" rowid="0">提示</h5>
									</div>
									<div class="modal-body">
										<h4>是否删除这些用户信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>

					</div>

					<div class="des-box" style="display: none">
						<h3 class="des-inf">院系信息</h3>
						<div id="toolbar2" class="btn-group">
							<button id="btn_edit" type="button"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#newacademy">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
							</button>
							<button id="btn_delete" type="button"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</div>
						<div class="table-box">
							<table id="academy-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar2">
							</table>
						</div>

						<!-- 添加modal -->
						<div class="modal fade" id="newacademy" tabindex="-1"
							role="dialog" aria-labelledby="addnewacademy" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewacademy">添加新院系</h3>
									</div>
									<div class="modal-body">

										<form>
											<div class="form-group">
												<label for="newacademyname" class="col-form-label">
													院系名:</label> <input type="text" class="form-control"
													id="newacademyname">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">添加</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 删除modal -->
						<div class="modal fade" id="delacademy" tabindex="-1"
							role="dialog" aria-labelledby="delacademy" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h5 class="modal-title" id="delacademy" rowid="0">提示</h5>
									</div>
									<div class="modal-body">
										<h4>是否删除该院系信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 院系批量删除modal -->
						<div class="modal fade" id="delacademys" tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h5 class="modal-title" rowid="0">提示</h5>
									</div>
									<div class="modal-body">
										<h4>是否删除这些院系信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>


					</div>

					<div class="des-box" style="display: none">
						<h3 class="des-inf">科目信息</h3>
						<div id="toolbar3" class="btn-group">
							<button id="btn_edit" type="button"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#newsubject">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
							</button>
							<button id="btn_delete" type="button"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</div>
						<div class="table-box">
							<table id="subject-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar3">
							</table>
						</div>
						<!-- 科目添加modal -->
						<div class="modal fade" id="newsubject" tabindex="-1"
							role="dialog" aria-labelledby="addnewsubject" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewsubject">添加新科目</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 院系名:</label> <select
													class="btn btn-default selectpicker">

												</select>
											</div>
											<div class="form-group">
												<label for="newsubjectname" class="col-form-label">
													科目名:</label> <input type="text" class="form-control"
													id="newsubjectname">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">添加</button>
									</div>
								</div>
							</div>
						</div>

						<!-- subject删除modal -->
						<div class="modal fade" id="delsubject" tabindex="-1"
							role="dialog" aria-labelledby="delacademy" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h5 class="modal-title" id="delacademy" rowid="0">提示</h5>
									</div>
									<div class="modal-body">
										<h4>是否删除该科目信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 院系批量删除modal -->
						<div class="modal fade" id="delsubjects" tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h5 class="modal-title" rowid="0">提示</h5>
									</div>
									<div class="modal-body">
										<h4>是否删除这些科目信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>

		</div>


		<div id="bottom"></div>
	</div>
</body>
</html>