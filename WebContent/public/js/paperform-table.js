$(document).ready(function () {

	function showData() {
		$('#paperform-table').bootstrapTable('refresh');
	}
	useracademy = $('#user-info input').val();
	var toolbar8;
	var subjectlist8;
	$('.second-row').click(function(){
		secondrow_inf = $('.second-row').eq(7).hasClass("secondchoosen");
		if(secondrow_inf){
			subjectlist8 = $('.des-box').eq(10).find('select');
			toolbar8 = $('#toolbar8');
			//获取科目信息
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist8.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist8.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			//找到确认按钮
			subjectbutton = $('.des-box').eq(10).find('.select-group button');
			var count8 = 0;
			subjectbutton.click(function(){
				if(subjectlist8.find("option:selected").attr("value") > 0){
					//获得选中的科目
					subjectname = subjectlist8.find("option:selected").text();
					//显示查找的章节信息
					$("#paperform-table").bootstrapTable('destroy');
					console.log("试卷模板表初始化:" + secondrow_inf);
					$.get("./user/paperformbysubject?subjectname=" + subjectname, function(result) {
						toolbar8.css("display","");
						$("#paperform-table").bootstrapTable({ // 对应table标签的id
					        url: "./user/paperformbysubject?subjectname=" + subjectname, // 获取表格数据的url
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
				            width: 60,
				        }, {
				            field: 'name',
				            title: '模板名',
				            align: 'center',
				            valign: 'middle',
				            width: 350,
				        },{
				            field: 'chapterName',
				            title: '考试范围',
				            align: 'center',
				            valign: 'middle',
				            width: 222,
				        },{
				            field: 'dif_coefficient',
				            title: '难度',
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
				            field: 'score',
				            title: '总分',
				            align: 'center',
				            valign: 'middle',
				            width: 80,
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
						if(++count8 == 1)
						toastr.warning('请选择科目');
						}
			});
			
		}else{
			if(subjectlist8 != null){
				subjectlist8.empty();
				toolbar8.css("display","none");
			}
			console.log("试卷模板表销毁：" + secondrow_inf);
			$("#paperform-table").bootstrapTable('destroy');
		}
	});
	
	//批量删除
	$('#toolbar8 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var paperformsdelcount = 0;
		console.log("长度：" + $('#paperform-table tbody').find('input:checkbox:checked').length);
		if($('#paperform-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar8 button').eq(1).attr("data-target","#delpaperforms");
			checkbox = $('#paperform-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delpaperforms').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++paperformsdelcount == 1){
					delbutton.click(function() {
						$.ajax("./user/delpaperforms", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
							toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delpaperforms').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("删除失败");
							toastr.error('删除失败，请重试');
							});
						});
					}
				});
		}else{
			$('#toolbar8 button').eq(1).attr("data-target","");
			toastr.warning('请勾选需要删除的用户');
		}
	});
	
	
});
