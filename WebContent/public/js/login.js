$(document).ready(function() {
	console.log('loading...');
	// var text_load = $("#loading-text-box").children(1);
	// var text_null = $("#loading-text-box").children(2);
	// var text_error = $("#loading-text-box").children(3);

	// var username = $("#username")
	// var password = $("#password")
//	function getUrlPara(name) {
//		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
//		var r = window.location.search.substr(1).match(reg);
//		if (r != null)
//			return (r[2]);
//		return null;
//	}

	var text_null = $("#text-null");
	var text_error = $("#text-error");

	text_error.slideToggle("slow").delay(3000).slideToggle("slow");

	$("#username").blur(function() {
		if ($("#username").val() == "")
			text_null.slideToggle("slow").delay(2000).slideToggle("slow");
	})
	$("#password").blur(function() {
		if ($("#username").val() == "")
			text_null.slideToggle("slow").delay(2000).slideToggle("slow");
	})

	// console.log($("#loading-text-box").children().length);
	// $('#submit').click(function() {

	// var account = $('#account').val();
	// var password = $('#password').val();
	// console.log('loading:', account, password)

	// if (account == "" || password == "") {
	// text_load.attr({"style":"display:none"});
	// text_null.attr({"style":""});

	// text_null.slideToggle("slow");
	// text_null.delay(2000).slideToggle("slow");
	// }

	// else {
	// var user = {
	// account : account,
	// password : password
	// }
	// // ajax提交请求
	// $.ajax('/login', {
	// method : 'POST',
	// data : JSON.stringify(user),
	// contentType : "application/json"
	// }).done(function() {
	// console.log('连接成功...');
	// var loadInfo = '<%=model.getAttribute("loadInfo")%>';
	// console.log(loadInfo);
	// if (loadInfo == "error"){
	// text_error.slideToggle("slow").delay(2000).slideToggle("slow");
	// }
	// }).fail(function() {
	// console.log('failed...')
	// text_fail.slideToggle("slow");
	// text_fail.delay(2000).slideToggle("slow");
	// });
	// }

	// });
});
