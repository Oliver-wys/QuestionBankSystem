$(document).ready(function () {

	function showData() {
		$('#subject-table').bootstrapTable('refresh');
	}
	var desbox_inf;
	$('.row').click(function(){
		desbox_inf = $("[des = 'subject']").hasClass("choosen");
		if(desbox_inf){
			console.log("科目表初始化：" + desbox_inf);
			$.get("./manager/allsubject", function(result) {
				console.log(result);
				$("#subject-table").bootstrapTable({ // 对应table标签的id
			        url: "./manager/allsubject", // 获取表格数据的url
			        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
			        striped: true,  //表格显示条纹，默认为false
			        pagination: true, // 在表格底部显示分页组件，默认false
			        pageList: [7], // 设置页面可以显示的数据条数
			        pageSize: 7, // 页面数据条数
			        dataType: "json",
			        method: 'get',
			        data: result,
			        cache: false,
			        sidePagination: 'client', // 设置为服务器端分页
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
		            title: '科目名',
		            align: 'center',
		            valign: 'middle',
		            width: 406,
		        }, {
		            field: 'academyName',
		            title: '所属院系',
		            align: 'center',
		            valign: 'middle',
		            width: 406,
		        },{
		            title: "操作",
		            align: 'center',
		            valign: 'middle',
		            width: 120, // 定义列的宽度，单位为像素px
		            formatter: function (value, row, index) {
		                var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delsubject" onclick="delsubject(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
		                var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#editsubject" onclick="editsubject(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>'
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
			$("#subject-table").bootstrapTable('destroy');
			console.log("科目表销毁：" + desbox_inf);
		}
	});
	
	//添加科目
	var subjectaddcount = 0;
	$('#newsubject').on('show.bs.modal', function (event) {
		var modal = $(this);
		var academylist = modal.find('select');
		var addbutton = modal.find('.modal-footer button').eq(1);
		var academyname;
		var subjectname;
		academylist.empty();
		$.get("./manager/allacademy", function(data) {
			academylist.append("<option> ---请选择--- </option>");
			for(var i=0; i < data.length; i++){
				academylist.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
			}
		});
		if(++subjectaddcount == 1){
			addbutton.click(function(){
				academylist = modal.find('select');
				subjectname = modal.find(".form-group input").eq(0).val();
				console.log("list:" + academylist.html());
				if(academylist.find("option:selected").attr("value") > 0){
					academyname = academylist.find("option:selected").text();
					console.log("academyname:" + academyname);
					console.log("subjectname:" + subjectname);
					if(subjectname == ""){
						toastr.warning('请完填写科目名');
					}else{
						var newsubject = {
								academyName : academyname,
								name : subjectname
						}
						$.ajax('./manager/addsubject', {
							method : 'post',
							data : JSON.stringify(newsubject),
							contentType : "application/json"
						}).done(function() {
							console.log("添加成功");
							toastr.success('添加成功');
							showData();
							//清空数据
							modal.find('.form-group input').val("");
							$('#newsubject').modal('hide');
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
	
	//删除科目
	var subjectdelcount = 0;
	window.delsubject = function(id){
		console.log("id:" + id);
		var subjectid;
		$('#delsubject').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++subjectdelcount == 1){
				delbutton.click(function() {
					subjectid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./manager/delsubject", {
						method: 'post',
						data : {id : subjectid},
					}).done(function() {
						console.log("删除成功");
						toastr.success('删除成功');
						showData();
						//隐藏数据
						$('#delsubject').modal('hide');
					}).fail(function() {
						// 如果响应码不是2打头
						console.log("删除失败");
						toastr.error('删除失败，请重试');
						});
					});
				}
			});
	}
	
	//批量删除科目
	$('#toolbar3 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var subjectsdelcount = 0;
		console.log("长度：" + $('#subject-table tbody').find('input:checkbox:checked').length);
		if($('#subject-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar3 button').eq(1).attr("data-target","#delsubjects");
			checkbox = $('#subject-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delsubjects').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++subjectsdelcount == 1){
					delbutton.click(function() {
						$.ajax("./manager/delsubjects", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delsubjects').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("删除失败");
							toastr.error('删除失败，请重试');
							});
						});
					}
				});
		}else{
			$('#toolbar3 button').eq(1).attr("data-target","");
			toastr.warning('请勾选需要删除的用户');
		}
	});
	
	
});
