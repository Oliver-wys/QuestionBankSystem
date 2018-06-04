$(document).ready(function() {

	function showData() {
		$('#user-table').bootstrapTable('refresh');
	}
	
	var desbox_inf
	$('.row').click(function(){
		desbox_inf = $("[des='user']").hasClass("choosen");
		if(desbox_inf){
			console.log("用户表初始化:"+desbox_inf);
			$.get("./manager/allusers", function(result) {
				$("#user-table").bootstrapTable({ // 对应table标签的id
					url: "./manager/allusers", // 获取表格数据的url
					cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
					striped: true,  //表格显示条纹，默认为false
					pagination: true, // 在表格底部显示分页组件，默认false
					pageList: [8], // 设置页面可以显示的数据条数
					pageSize: 8, // 页面数据条数
					dataType: "json",
					method: 'get',
					data: result,
					cache: false,
					sidePagination: 'client', // 设置为服务器端分页
					sortName: 'id', // 要排序的字段
					columns: [{  
							checkbox: true, // 显示一个勾选框
							align: 'center',
							valign: 'middle',
							width:36,
						},{
							field: 'id', // 返回json数据中的name
							title: '编号', // 表格表头显示文字
							align: 'center',
							valign: 'middle',
							width: 60,
						}, {
							field: 'account',
							title: '账号',
							align: 'center',
							valign: 'middle',
							width: 100,
						}, {
							field: 'name',
							title: '用户名',
							align: 'center',
							valign: 'middle',
							width: 120,
						},{
							field: 'gender',
							title: '性别',
							align: 'center',
							valign: 'middle',
							width: 80,
							editable:true
						}, {
							field: 'phoneNum',
							title: '联系方式',
							align: 'center',
							valign: 'middle',
							width: 250,
							editable:true
						}, {
							field: 'academyName',
							title: '学院',
							align: 'center',
							valign: 'middle',
							width: 282,
							editable:true
						}, {
							title: "操作",
							align: 'center',
							valign: 'middle',
							width: 120, // 定义列的宽度，单位为像素px
							formatter: function (value, row, index) {
								var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deluser" onclick="deluser(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
								var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#edituser" onclick="edituser(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>'
								return edibtn + delbtn ;
							}
						}],
						//加载成功时执行
						onLoadSuccess: function () {
							$("[name='refresh']").attr({"style":"height:34px"});
							console.info("加载成功");
						},
						//加载失败时执行
						onLoadError: function () {
							console.info("加载数据失败");
						}
				});
			});
		}else{
			console.log("用户表销毁:"+desbox_inf);
			$('#user-table').bootstrapTable('destroy');
//			console.log("销毁的结果");
		}
	});
//	console.log($('#user-table').parent().parent().attr("class"));
	
	//添加用户
	var useraddcount = 0;
	$('#newuser').on('show.bs.modal', function (event) {
		var modal = $(this);
		var academylist = modal.find('select');
		var addbutton = modal.find('.modal-footer button').eq(1);
		var account;
		var password;
		var academyname;
		academylist.empty();
		$.get("./manager/allacademy", function(data) {
			academylist.append("<option> ---请选择--- </option>");
			for(var i=0; i < data.length; i++){
				academylist.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
			}
		});	
		if(++useraddcount == 1){	
			addbutton.click(function(){
				academylist = modal.find('select');
//				console.log("找到添加按钮了");
//				console.log(academylist.find("option:selected").attr("value"));
				account = modal.find(".form-group input").eq(0).val();
				password = modal.find(".form-group input").eq(1).val();
				
				if(academylist.find("option:selected").attr("value") > 0){
					academyname = academylist.find("option:selected").text();
					console.log("academyname:" + academyname);
					console.log("account:" + account);
					console.log("password:" + password);
					if(account == "" || password == ""){
						toastr.warning('请完成信息填写');
					}else{
						var newuser = {
								academyName : academyname,
								account : account,
								password : password,
								isManager : 2
						}
						$.ajax('./manager/adduser', {
							method : 'post',
							data : JSON.stringify(newuser),
							contentType : "application/json"
						}).done(function() {
							console.log("添加成功");
							toastr.success('添加成功');
							showData();
							//清空数据
							modal.find('.form-group input').val("");
							$('#newuser').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("创建失败");
							toastr.error('添加失败，请重试');
							});
					}
				}else{
					toastr.warning('请选择院系');
				}
			});
		}	
	});
	
	//批量删除用户
	$('#toolbar1 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var usersdelcount = 0;
		console.log("长度：" + $('#user-table tbody').find('input:checkbox:checked').length);
		if($('#user-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar1 button').eq(1).attr("data-target","#delusers");
			checkbox = $('#user-table tbody').find('input:checkbox:checked');
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delusers').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++usersdelcount == 1){
					delbutton.click(function() {
						$.ajax("./manager/delusers", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delusers').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("删除失败");
							toastr.error('删除失败，请重试');
							});
						});
					}
				});
		}else{
			$('#toolbar1 button').eq(1).attr("data-target","");
			toastr.warning('请勾选需要删除的用户');
		}
	});
	
	
	//删除用户
	var userdelcount = 0;
	window.deluser = function(id){
		console.log("id:" + id);
		var userid;
		$('#deluser').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++userdelcount == 1){
				delbutton.click(function() {
					userid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./manager/deluser", {
						method: 'post',
						data : {id : userid},
					}).done(function() {
						console.log("删除成功");
							toastr.success('删除成功');
						showData();
						//隐藏数据
						$('#deluser').modal('hide');
					}).fail(function() {
						// 如果响应码不是2打头
						
						console.log("删除失败");
						
						toastr.error('删除失败，请重试');
						});
					});
				}
			});
	}
	
	


});
