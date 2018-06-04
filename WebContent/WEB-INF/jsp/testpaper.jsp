<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/toastr.min.js"></script>
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/css/toastr.min.css">
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/QuestionBankSystem/assets/css/paperview.css">
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/jquery.min.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/testpaperview.js"></script>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/bootstrap/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷预览</title>
</head>
<body>
	<div class="container">
		<h1>${testpaper.testInf.name}</h1>
		<div class="inf-box">
			<label>科目：${testpaper.testInf.subjectName}</label> <label>总分：${testpaper.testInf.score}分</label>
			<label>考试时长：${testpaper.testInf.time}</label>
		</div>
		<c:if test="${testpaper.singles.size() > 0}">
			<div class="question">
				<h4>（一）单选题：（总共${testpaper.singles.size()}道题，每道题${testpaper.paperForm.singleScore}分）</h4>
				<c:forEach var="single" items="${testpaper.singles}" varStatus="vs">
					<div class="singlebox">
						<div class="questionleft">
							<h5>${vs.index + 1}.${single.body}</h5>
						</div>
						<div class="questionright">（&nbsp;&nbsp;）</div>
						<div class="option">A.${single.optionA}</div>
						<div class="option">B.${single.optionB}</div>
						<div class="option">C.${single.optionC}</div>
						<div class="option">D.${single.optionD}</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${testpaper.multis.size() > 0}">
			<div class="question">
				<h4>（二）多选题：（总共${testpaper.multis.size()}道题，每道题${testpaper.paperForm.multiScore}分）
				</h4>
				<c:forEach var="multi" items="${testpaper.multis}" varStatus="vs">
					<div class="multibox">
						<div class="questionleft">
							<h5>${vs.index + 1}.${multi.body}</h5>
						</div>
						<div class="questionright">（&nbsp;&nbsp;）</div>
						<div class="option">A.${multi.optionA}</div>
						<div class="option">B.${multi.optionB}</div>
						<div class="option">C.${multi.optionC}</div>
						<div class="option">D.${multi.optionD}</div>
						<div class="option">E.${multi.optionE}</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${testpaper.judges.size() > 0}">
			<div class="question">
				<h4>（三）判断题：（总共${testpaper.multis.size()}道题，每道题${testpaper.paperForm.multiScore}分）
				</h4>
				<c:forEach var="multi" items="${testpaper.multis}" varStatus="vs">
					<div class="judgebox">
						<div class="questionleft">
							<h5>${vs.index + 1}.${multi.body}</h5>
						</div>
						<div class="questionright">
							<span>（ &nbsp;&nbsp;）</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${testpaper.completions.size() > 0}">
			<div class="question">
				<h4>（四）填空题：（总共${testpaper.completions.size()}道题，每道题${testpaper.paperForm.completionScore}分）</h4>
				<c:forEach var="completion" items="${testpaper.completions}"
					varStatus="vs">
					<div class="completionbox">
						<h5>${vs.index + 1}.${completion.body}</h5>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${testpaper.shorts.size() > 0}">
			<div class="question">
				<h4>（五）简答题：（总共${testpaper.shorts.size()}道题，每道题${testpaper.paperForm.shortScore}分）</h4>
				<c:forEach var="shortvalue" items="${testpaper.shorts}"
					varStatus="vs">
					<div class="shortbox">
						<h5>${vs.index + 1}.${shortvalue.body}</h5>
						<div class="answerplace"></div>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<div>
			<button class="btn btn-primary" id="savebutton">保存</button>
		</div>
	</div>

</body>
</html>