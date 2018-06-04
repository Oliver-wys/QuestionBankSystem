<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园题库管理系统</title>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/jquery.min.js"></script>

<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap-table/dist/bootstrap-table.css">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap-table/dist/bootstrap-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap/css/bootstrap-multiselect.css">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap/js/bootstrap-multiselect.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/toastr.min.js"></script>
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/css/toastr.min.css">

<link rel="stylesheet" href="/QuestionBankSystem/assets/css/main.css">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/user.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/chapter-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/single-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/multi-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/judge-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/completion-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/short-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/testpaper-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/paperform-table.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/manualpaper.js"></script>

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
							<p>用户：${curuser.name}</p>
							<input type="hidden" value="${curuser.academyName}"></input>
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
						<div class="row" des="chapter">
							<p>章节管理</p>
						</div>
						<div class="second-row" des="chapter" style="display: none">
							<p>章节信息</p>
						</div>
						<div class="row" des="bank">
							<p>题库管理</p>
						</div>
						<div class="second-row" des="bank" style="display: none">
							<p>单选题</p>
						</div>
						<div class="second-row" des="bank" style="display: none">
							<p>多选题</p>
						</div>
						<div class="second-row" des="bank" style="display: none">
							<p>判断题</p>
						</div>
						<div class="second-row" des="bank" style="display: none">
							<p>填空题</p>
						</div>
						<div class="second-row" des="bank" style="display: none">
							<p>简答题</p>
						</div>
						<div class="row" des="paper">
							<p>试卷管理</p>
						</div>
						<div class="second-row" des="paper" style="display: none">
							<p>试卷信息</p>
						</div>
						<div class="second-row" des="paper" style="display: none">
							<p>模板信息</p>
						</div>
						<div class="second-row" des="paper" style="display: none">
							<p>人工组卷</p>
						</div>
						<div class="second-row" des="paper" style="display: none">
							<p>模板组卷</p>
						</div>
						<div class="row" des="info">
							<p>个人信息</p>
						</div>
						<div class="second-row" des="info" style="display: none">
							<p>查看信息</p>
						</div>



					</div>
				</div>
				<div id="box-right">
					<div class="des-box" style="display: none"></div>
					<div class="des-box" style="display: none">
						<h3 class="des-inf">章节信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group" id="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>


						<div class="table-box">
							<div id="toolbar1" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newchapter">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="chapter-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar1">
							</table>
						</div>
						<!-- 章节添加modal -->
						<div class="modal fade" id="newchapter" tabindex="-1"
							role="dialog" aria-labelledby="addnewchapter" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewchapter">添加新章节</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label for="newchaptername" class="col-form-label">
													章节名:</label> <input type="text" class="form-control"
													id="newchaptername">
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

						<!-- 章节删除modal -->
						<div class="modal fade" id="delchapter" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除该章节信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 章节批量删除modal -->
						<div class="modal fade" id="delchapters" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除这些章节信息？</h4>
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
					<div class="des-box" style="display: none"></div>
					<div class="des-box" style="display: none">
						<h3 class="des-inf">单选题信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>
						<div class="table-box">
							<div id="toolbar2" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newsingle">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="single-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar2">
							</table>
						</div>

						<!-- 单选题添加modal -->
						<div class="modal fade" id="newsingle" tabindex="-1" role="dialog"
							aria-labelledby="addnewsingle" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewsingle">添加新单选题</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 章节:</label> <select
													class="btn btn-default selectpicker">
												</select> <label class="col-form-label"> 难度系数:</label> <select
													class="btn btn-default selectpicker">
													<option>请选择难度系数</option>
													<option value="1">简单</option>
													<option value="2">普通</option>
													<option value="3">困难</option>
												</select>

												<div class="input-group">
													<span class="input-group-addon">题干：</span>
													<textarea class="form-control" aria-label="singlebody"></textarea>
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项A</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项B</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项C</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项D</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												</select> <label class="col-form-label"> 答案:</label> <select
													class="btn btn-default selectpicker">
													<option>请选择答案</option>
													<option value="1">A</option>
													<option value="2">B</option>
													<option value="3">C</option>
													<option value="4">D</option>
												</select>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">确认</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 单选题删除modal -->
						<div class="modal fade" id="delsingle" tabindex="-1" role="dialog"
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
										<h4>是否删除该单选题信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 单选题批量删除modal -->
						<div class="modal fade" id="delsingles" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除这些单选题信息？</h4>
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
						<h3 class="des-inf">多选题信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>
						<div class="table-box">
							<div id="toolbar3" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newmulti">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="multi-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar3">
							</table>
						</div>

						<!-- 多选题添加modal -->
						<div class="modal fade" id="newmulti" tabindex="-1" role="dialog"
							aria-labelledby="addnewmulti" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewmulti">添加多选题</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 章节:</label> <select
													class="btn btn-default selectpicker">
												</select> <label class="col-form-label"> 难度系数:</label> <select
													class="btn btn-default selectpicker">
													<option>请选择难度系数</option>
													<option value="1">简单</option>
													<option value="2">普通</option>
													<option value="3">困难</option>
												</select>

												<div class="input-group">
													<span class="input-group-addon">题干：</span>
													<textarea class="form-control" aria-label="singlebody"></textarea>
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项A</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项B</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项C</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项D</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="input-group">
													<span class="input-group-addon">选项E</span> <input
														type="text" class="form-control"
														aria-describedby="optionA">
												</div>
												<div class="checkbox-box">
													<div class="form-check form-check-inline">
														<label class="col-form-label"> 答案:</label> <input
															class="form-check-input" type="checkbox" id="optionA"
															value="A"> <label class="form-check-label"
															for="optionA">A</label> <input class="form-check-input"
															type="checkbox" id="optionB" value="B"> <label
															class="form-check-label" for="optionB">B</label> <input
															class="form-check-input" type="checkbox" id="optionC"
															value="C"> <label class="form-check-label"
															for="optionC">C</label> <input class="form-check-input"
															type="checkbox" id="optionD" value="D"> <label
															class="form-check-label" for="optionD">D</label> <input
															class="form-check-input" type="checkbox" id="optionE"
															value="E"> <label class="form-check-label"
															for="optionE">E</label>
													</div>
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">确认</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 多选题删除modal -->
						<div class="modal fade" id="delmulti" tabindex="-1" role="dialog"
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
										<h4>是否删除该多选题信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 多选题批量删除modal -->
						<div class="modal fade" id="delmultis" tabindex="-1" role="dialog"
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
										<h4>是否删除这些多选题信息？</h4>
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
						<h3 class="des-inf">判断题信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>

						<div class="table-box">
							<div id="toolbar4" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newjudge">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="judge-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar4"
								class="table table-condensed table-bordered">
							</table>
						</div>

						<!-- 判断题添加modal -->
						<div class="modal fade" id="newjudge" tabindex="-1" role="dialog"
							aria-labelledby="addnewjudge" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewjudge">添加判断题</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 章节:</label> <select
													class="btn btn-default selectpicker">
												</select> <label class="col-form-label"> 难度系数:</label> <select
													class="btn btn-default selectpicker">
													<option>请选择难度系数</option>
													<option value="1">简单</option>
													<option value="2">普通</option>
													<option value="3">困难</option>
												</select>

												<div class="input-group">
													<span class="input-group-addon">题干</span>
													<textarea class="form-control" aria-label="singlebody"></textarea>
												</div>
												<div class="input-group">
													<span class="input-group-addon">答案</span> <input
														type="text" class="form-control" aria-describedby="answer">
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">确认</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 判断题删除modal -->
						<div class="modal fade" id="deljudge" tabindex="-1" role="dialog"
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
										<h4>是否删除该判断题信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 判断批量删除modal -->
						<div class="modal fade" id="deljudges" tabindex="-1" role="dialog"
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
										<h4>是否删除这些判断题信息？</h4>
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
						<h3 class="des-inf">填空题信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>

						<div class="table-box">
							<div id="toolbar5" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newcompletion">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="completion-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar5">
							</table>
						</div>

						<!-- 填空题添加modal -->
						<div class="modal fade" id="newcompletion" tabindex="-1"
							role="dialog" aria-labelledby="addnewcompletion"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewcompletion">添加新填空题</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 章节:</label> <select
													class="btn btn-default selectpicker">
												</select> <label class="col-form-label"> 难度系数:</label> <select
													class="btn btn-default selectpicker">
													<option>请选择难度系数</option>
													<option value="1">简单</option>
													<option value="2">普通</option>
													<option value="3">困难</option>
												</select>

												<div class="input-group">
													<span class="input-group-addon">题干</span>
													<textarea class="form-control" aria-label="singlebody"></textarea>
												</div>
												<div class="input-group">
													<span class="input-group-addon">答案</span> <input
														type="text" class="form-control" aria-describedby="answer">
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">确认</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 填空题删除modal -->
						<div class="modal fade" id="delcompletion" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除该填空题信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 填空批量删除modal -->
						<div class="modal fade" id="delcompletions" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除这些填空题信息？</h4>
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
						<h3 class="des-inf">简答题信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>

						<div class="table-box">
							<div id="toolbar6" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newshort">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="short-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar6">
							</table>
						</div>

						<!-- 填空题添加modal -->
						<div class="modal fade" id="newshort" tabindex="-1" role="dialog"
							aria-labelledby="addnewshort" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title" id="addnewshort">添加新简答题</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label class="col-form-label"> 章节:</label> <select
													class="btn btn-default selectpicker">
												</select> <label class="col-form-label"> 难度系数:</label> <select
													class="btn btn-default selectpicker">
													<option>请选择难度系数</option>
													<option value="1">简单</option>
													<option value="2">普通</option>
													<option value="3">困难</option>
												</select>

												<div class="input-group">
													<span class="input-group-addon">题干</span>
													<textarea class="form-control" aria-label="singlebody"></textarea>
												</div>
												<div class="input-group">
													<span class="input-group-addon">答案</span>
													<textarea class="form-control" aria-label="shortbody"></textarea>
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">确认</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 简答题删除modal -->
						<div class="modal fade" id="delshort" tabindex="-1" role="dialog"
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
										<h4>是否删除该简答题信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 简答批量删除modal -->
						<div class="modal fade" id="delshorts" tabindex="-1" role="dialog"
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
										<h4>是否删除这些简答题信息？</h4>
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

					<div class="des-box" style="display: none"></div>
					<div class="des-box" style="display: none">
						<h3 class="des-inf">试卷信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>

						<div class="table-box">
							<div id="toolbar7" class="btn-group" style="display: none">

								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="testinf-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar7">
							</table>
						</div>

						<!-- 试卷信息删除modal -->
						<div class="modal fade" id="deltestinf" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除该试卷信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 试卷信息批量删除modal -->
						<div class="modal fade" id="deltestinfs" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除这些试卷信息？</h4>
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
						<h3 class="des-inf">模板信息</h3>
						<!-- 下拉菜单 -->
						<div class="select-group">
							<span>请选择科目:</span> <select class="btn btn-default selectpicker">
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>

						<div class="table-box">
							<div id="toolbar8" class="btn-group" style="display: none">
								<button id="btn_edit" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="#newpaperform">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
								</button>
								<button id="btn_delete" type="button"
									class="btn btn-default btn-sm" data-toggle="modal"
									data-target="">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="paperform-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar8">
							</table>
						</div>

						<!-- 试卷模板添加modal -->
						<div class="modal fade" id="newpaperform" tabindex="-1"
							role="dialog" 
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">信息模板添加</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button type="button" class="btn btn-primary">保存</button>
									</div>
								</div>
							</div>
						</div>

						<!-- 模板删除modal -->
						<div class="modal fade" id="delpaperform" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除该试卷模板信息？</h4>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-danger">确认删除</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 模板批量删除modal -->
						<div class="modal fade" id="delpaperforms" tabindex="-1"
							role="dialog" aria-hidden="true">
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
										<h4>是否删除这些试卷模板信息？</h4>
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
						<h3 class="des-inf">人工组卷</h3>
						<div class="select-group">
							<span>科目:</span> <select class="btn btn-default selectpicker">
							</select> <span> 难度系数:</span> <select class="btn btn-default selectpicker">
								<option>请选择难度系数</option>
								<option value="1">简单</option>
								<option value="2">普通</option>
								<option value="3">困难</option>
							</select>
							<button type="button" class="btn btn-info">确认</button>
						</div>

						<div class="table-box" style="display: none">
							<input type="hidden" value="${curuser.name }">
							<div class="paper-box">
								<div class="input-group">
									<span class="input-group-addon">考试标题</span> <input type="text"
										class="form-control" placeholder="请输入考试标题(必要信息)"
										aria-describedby="basic-addon1">
								</div>
								<div class="form-row">
									<div class="col-lg-6">
										<div class="input-group">
											<span class="input-group-addon"> 总分 </span> <input
												type="text" class="form-control" placeholder="请输入试卷总分(必要信息)">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="input-group">
											<span class="input-group-addon"> 时长 </span> <input
												type="text" class="form-control" placeholder="请输入考试时长(必要信息)">
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 单选题量 </span> <input
												type="text" class="form-control" placeholder="请输入单选题量">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 单选分值 </span> <input
												type="text" class="form-control" placeholder="请输入单选分值">
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 多选题量 </span> <input
												type="text" class="form-control" placeholder="请输入多选题量">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 多选分值 </span> <input
												type="text" class="form-control" placeholder="请输入多选分值">
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 判断题量 </span> <input
												type="text" class="form-control" placeholder="请输入判断题量">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 判断分值 </span> <input
												type="text" class="form-control" placeholder="请输入判断分值">
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 填空题量 </span> <input
												type="text" class="form-control" placeholder="请输入填空题量">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 填空分值 </span> <input
												type="text" class="form-control" placeholder="请输入填空分值">
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 简答题量 </span> <input
												type="text" class="form-control" placeholder="请输入简答题量">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="input-group input-group-sm">
											<span class="input-group-addon"> 简答分值 </span> <input
												type="text" class="form-control" placeholder="请输入简答分值">
										</div>
									</div>
								</div>
								<div class="checkboxgroup">
									<label>选择章节范围：</label> <input type="checkbox" id="allcheck"><label>全选</label>
									<div class="checkbox-box"></div>
								</div>
								<button type="button" class="btn btn-primary">提交</button>


							</div>

						</div>
					</div>

					<div class="des-box" style="display: none">
						<h3 class="des-inf">模板组卷</h3>
						<div id="toolbar10" class="btn-group">
							<button id="btn_edit" type="button"
								class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
							</button>
							<button id="btn_delete" type="button"
								class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</div>
						<div class="table-box">
							<table id="single-table" data-classes="table table-hover"
								data-striped="true" data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar10">
							</table>

						</div>
					</div>

					<div class="des-box" style="display: none"></div>

					<div class="des-box" style="display: none">
						<h3 class="des-inf">查看信息</h3>

						<div class="userinf-box">
							<input type="hidden" value="${curuser.id}"></input>
							<ul class="list-group">
								<li class="list-group-item"><label>用户账号：</label><span>${curuser.account}</span></li>
								<li class="list-group-item list-group-item-info"><label>所属学院：</label><span>${curuser.academyName}</span></li>
								<li class="list-group-item"><label>用户姓名：</label><span>${curuser.name}</span></li>
								<li class="list-group-item list-group-item-info"><label>用户性别：</label><span>${curuser.gender}</span></li>
								<li class="list-group-item"><label>联系方式：</label><span>${curuser.phoneNum}</span></li>
							</ul>
							<div class="button-group">
								<button id="inf-change" class="btn btn-info" data-toggle="modal"
									data-target="#changeinf">修改</button>
							</div>
						</div>
						<!-- 修改信息modal -->
						<div class="modal fade" id="changeinf" tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h3 class="modal-title">修改用户信息</h3>
									</div>
									<div class="modal-body">
										<form>
											<div class="form-group">
												<label for="newaccount" class="col-form-label">
													用户姓名:</label> <input type="text" class="form-control"
													value="${curuser.name}"> <label
													class="col-form-label"> 用户性别:</label> <input type="text"
													class="form-control" value="${curuser.gender}"> <label
													for="newpassword" class="col-form-label"> 联系方式:</label> <input
													type="text" class="form-control"
													value="${curuser.phoneNum}">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">关闭</button>
										<button class="btn btn-primary">确认</button>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- <div class="des-box" style="display: none">
						<h3 class="des-inf">修改信息</h3>
						<div id="toolbar11" class="btn-group">
							<button id="btn_edit" type="button"
								class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
							</button>
							<button id="btn_delete" type="button"
								class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</div>
						<div class="table-box">
							<table data-toggle="single-table" id="single-table"
								data-classes="table table-hover" data-striped="true"
								data-pagination="true" data-search="true"
								data-show-refresh="true" data-show-columns="true"
								data-toolbar="#toolbar11">
							</table>

						</div>
					</div> -->
				</div>
			</div>

		</div>


		<div id="bottom"></div>
	</div>
</body>
</html>