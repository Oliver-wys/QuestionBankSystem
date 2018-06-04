$(document).ready(function() {
	 toastr.options.positionClass = 'toast-bottom-right';
	$('#savebutton').click(function() {
			toastr.success('添加成功');
			console.log("提交成功");
			$.get("./addtestinf", function(data, textStatus, req) {});
	});
})