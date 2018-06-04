$(document).ready(function () {

	function showData() {
		$('#academy-table').bootstrapTable('refresh');
	}
	var desbox_inf;
	$('.row').click(function(){
		desbox_inf = $("[des = 'academy']").hasClass("choosen");
		if(desbox_inf){
			console.log("学院表初始化：" + desbox_inf)
			$.get("./manager/allacademy", function(result) {
				console.log(result);
				$("#academy-table").bootstrapTable({ // 对应table标签的id
			        url: "./manager/allacademy", // 获取表格数据的url
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
			        sortable: true,//是否启用排序
			        sortName: 'id', // 要排序的字段
		        columns: [{
		        	checkbox: true,
		        	align: 'center',
		        	valign: 'middle',
		        	width: 36,
		        },{
		            field: 'id', // 返回json数据中的name
		            title: '编号', // 表格表头显示文字
		            align: 'center',
		            valign: 'middle',
		            width: 80,
		        }, {
		            field: 'name',
		            title: '院系名',
		            align: 'center',
		            valign: 'middle',
		            width: 812,
		        }, {
		            title: "操作",
		            align: 'center',
		            valign: 'middle',
		            width: 120, // 定义列的宽度，单位为像素px
		            formatter: function (value, row, index) {
		                var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#editacademy" onclick="editacademy(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>';
		                var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delacademy" onclick="delacademy(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>'
		            	return edibtn + delbtn ;
		            }
		        }
		        ],
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
			$('#academy-table').bootstrapTable('destroy');
			console.log("学院表销毁："+desbox_inf);
		}
	});
	
	
	
	var academyaddcount = 0;
	var academydelcount = 0;
	var academydelscount = 0;
	//添加学院信息
	$('#newacademy').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) ;// Button that triggered the modal
		  var modal = $(this);
		  var newacademyname;
		  var newacademy;
		  var addbutton = modal.find('.modal-footer button').eq(1);
//		  toastr.warning(modal.find('.modal-footer button').eq(1).length);
			
		  if (++academyaddcount == 1) {
			  addbutton.click(function(){
				  newacademyname = modal.find('.form-group input').val();
				  	if(newacademyname == ""){
				  		toastr.warning('请输入院系名');
				  	}else{
				  		console.log(newacademyname);
				  		newacademy = {
				  				name : newacademyname
				  				}
				  		$.ajax('./manager/addacademy', {
							method : 'post',
							data : JSON.stringify(newacademy),
							contentType : "application/json"
						}).done(function() {
							console.log("添加成功");
							toastr.success('添加成功');
							showData();
							//清空数据
							modal.find('.form-group input').val("");
							$('#newacademy').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("创建失败");
							toastr.error('添加失败，请重试');
							});
				  		}
			  });
			  }
	});
	
	//删除学院信息
//	var delcount = 0;
	window.delacademy = function(id){
		console.log("id:" + id);
		var academyid;
		$('#delacademy').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++academydelcount == 1){
				delbutton.click(function() {
					academyid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./manager/delacademy", {
						method: 'post',
						data : {id : academyid},
					}).done(function() {
						console.log("删除成功");
							toastr.success('删除成功');
						showData();
						//清空数据
						$('#delacademy').modal('hide');
					}).fail(function() {
						// 如果响应码不是2打头
						
						console.log("删除失败");
						
						toastr.error('删除失败，请重试');
						});
					});
				}
			});
	}
	
	//批量删除院系
	$('#toolbar2 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var academysdelcount = 0;
		console.log("长度：" + $('#academy-table tbody').find('input:checkbox:checked').length);
		if($('#academy-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar2 button').eq(1).attr("data-target","#delacademys");
			checkbox = $('#academy-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delacademys').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++academysdelcount == 1){
					delbutton.click(function() {
						$.ajax("./manager/delacademys", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delacademys').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("删除失败");
							toastr.error('删除失败，请重试');
							});
						});
					}
				});
		}else{
			$('#toolbar2 button').eq(1).attr("data-target","");
			toastr.warning('请勾选需要删除的用户');
		}
	});
	
	
});


