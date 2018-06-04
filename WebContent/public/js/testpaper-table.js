$(document).ready(function () {

	function showData() {
		$('#testinf-table').bootstrapTable('refresh');
	}
	useracademy = $('#user-info input').val();
	var toolbar7;
	var subjectlist7;
	$('.second-row').click(function(){
		secondrow_inf = $('.second-row').eq(6).hasClass("secondchoosen");
		if(secondrow_inf){
			subjectlist7 = $('.des-box').eq(9).find('select');
			toolbar7 = $('#toolbar7');
			//获取科目信息
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist7.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist7.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			//找到确认按钮
			subjectbutton = $('.des-box').eq(9).find('.select-group button');
			var count7 = 0;
			subjectbutton.click(function(){
				if(subjectlist7.find("option:selected").attr("value") > 0){
					//获得选中的科目
					subjectname = subjectlist7.find("option:selected").text();
					//显示查找的章节信息
					$("#testinf-table").bootstrapTable('destroy');
					console.log("试卷信息表初始化:" + secondrow_inf);
					$.get("./user/testinfbysubject?subjectname=" + subjectname, function(result) {
						toolbar7.css("display","");
						$("#testinf-table").bootstrapTable({ // 对应table标签的id
					        url: "./user/testinfbysubject?subjectname=" + subjectname, // 获取表格数据的url
					        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
					        striped: true,  //表格显示条纹，默认为false
					        pagination: true, // 在表格底部显示分页组件，默认false
					        pageList: [6], // 设置页面可以显示的数据条数
					        pageSize: 6, // 页面数据条数
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
				            title: '试卷标题',
				            align: 'center',
				            valign: 'middle',
				            width: 412,
				        },{
				            field: 'userName',
				            title: '操作者',
				            align: 'center',
				            valign: 'middle',
				            width: 100,
				        },{
				            field: 'createTime',
				            title: '创建时间',
				            align: 'center',
				            valign: 'middle',
				            width: 120,
				        },{
				            field: 'score',
				            title: '总分',
				            align: 'center',
				            valign: 'middle',
				            width: 80,
				        },{
				            field: 'time',
				            title: '考试时长',
				            align: 'center',
				            valign: 'middle',
				            width: 100,
				        },{
				            title: "操作",
				            align: 'center',
				            valign: 'middle',
				            width: 120, // 定义列的宽度，单位为像素px
				            formatter: function (value, row, index) {
				                var delbtn = '<button class="btn btn-danger btn-sm" onclick="edit(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
				                var edibtn = '<button class="btn btn-primary btn-sm" onclick="del(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>'
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
						if(++count7 == 1)
						toastr.warning('请选择科目');
						}
			});
			
		}else{
			if(subjectlist7 != null){
				subjectlist7.empty();
				toolbar7.css("display","none");
			}
			console.log("试卷信息表销毁：" + secondrow_inf);
			$("#testinf-table").bootstrapTable('destroy');
		}
	});
	
	//批量删除
	$('#toolbar7 button').eq(0).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var testinfsdelcount = 0;
		console.log("长度：" + $('#testinf-table tbody').find('input:checkbox:checked').length);
		if($('#testinf-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar7 button').eq(0).attr("data-target","#deltestinfs");
			checkbox = $('#testinf-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#deltestinfs').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++testinfsdelcount == 1){
					delbutton.click(function() {
						$.ajax("./user/deltestinfs", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#deltestinfs').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("删除失败");
							toastr.error('删除失败，请重试');
							});
						});
					}
				});
		}else{
			$('#toolbar7 button').eq(0).attr("data-target","");
			toastr.warning('请勾选需要删除的用户');
		}
	});
	
});
