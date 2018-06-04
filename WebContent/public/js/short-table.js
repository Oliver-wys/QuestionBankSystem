$(document).ready(function () {

	function showData() {
		$('#short-table').bootstrapTable('refresh');
	}
	useracademy = $('#user-info input').val();
	var toolbar6;
	var subjectlist6;
	$('.second-row').click(function(){
		secondrow_inf = $('.second-row').eq(5).hasClass("secondchoosen");
		if(secondrow_inf){
			subjectlist6 = $('.des-box').eq(7).find('select').eq(0);
			toolbar6 = $('#toolbar6');
			//获取科目信息
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist6.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist6.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			//找到确认按钮
			subjectbutton = $('.des-box').eq(7).find('.select-group button');
			var count6 = 0;
			subjectbutton.click(function(){
				if(subjectlist6.find("option:selected").attr("value") > 0){
					//获得选中的科目
					subjectname = subjectlist6.find("option:selected").text();
					//显示查找的章节信息
					$("#short-table").bootstrapTable('destroy');
					console.log("简答表初始化:" + secondrow_inf);
					$.get("./user/shortbysubject?subjectname=" + subjectname, function(result) {
						toolbar6.css("display","");
						$("#short-table").bootstrapTable({ // 对应table标签的id
					        url: "./user/shortbysubject?subjectname=" + subjectname, // 获取表格数据的url
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
				            width: 45,
				        }, {
				            field: 'chapterName',
				            title: '章节',
				            align: 'center',
				            valign: 'middle',
				            width: 65,
				        },{
				            field: 'dif_coefficient',
				            title: '难度',
				            align: 'center',
				            valign: 'middle',
				            width: 45,
				        },{
				            field: 'body',
				            title: '题干',
				            align: 'center',
				            valign: 'middle',
				            width: 500,
				        },{
				            field: 'answer',
				            title: '答案',
				            align: 'center',
				            valign: 'middle',
				            width: 275,
				        },{
				            title: "操作",
				            align: 'center',
				            valign: 'middle',
				            width: 80, // 定义列的宽度，单位为像素px
				            formatter: function (value, row, index) {
				                var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delshort" onclick="delshort(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
				                var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#newshort" onclick="editshort(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>'
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
						if(++count6 == 1)
						toastr.warning('请选择科目');
						}
			});
			
			
			
		}else{
			if(subjectlist6 != null){
				subjectlist6.empty();
				toolbar6.css("display","none");
			}
			console.log("简答表销毁：" + secondrow_inf);
			$("#short-table").bootstrapTable('destroy');
		}
	});
	
	//添加简答题
	var shortaddcount = 0;
	$('#newshort').on('show.bs.modal', function (event) {
		var modal = $(this);
		var chapterlist = modal.find('select').eq(0);
		var difficultlist;
		var questionbody;
		var chaptername;
		var difficultname;
		var answer;
		
		var addbutton = modal.find('.modal-footer button').eq(1);
		chapterlist.empty();
		$.get("./user/chapterbysubject?subjectname=" + subjectname, function(data) {
			chapterlist.append("<option> ---请选择--- </option>");
			for(var i=0; i < data.length; i++){
				chapterlist.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
			}
		});
			
		if(++shortaddcount == 1){
			addbutton.click(function(){
				//拿到单选题数据
				chapterlist = modal.find('select').eq(0);
				difficultlist = modal.find('select').eq(1);
				
				questionbody = modal.find('.input-group textarea').eq(0).val();
				answer = modal.find('.input-group textarea').eq(1).val();
				
				if(chapterlist.find("option:selected").attr("value") > 0 
						&& difficultlist.find("option:selected").attr("value") > 0
						&& answer != ""
						&& questionbody != ""){
					chaptername = chapterlist.find("option:selected").text();
					difficultname = difficultlist.find("option:selected").text();
					var newshort  = {
							academyName : useracademy,
							subjectName : subjectname,
							chapterName : chaptername,
							dif_coefficient : difficultname,
							body : questionbody,
							answer : answer
					}
					console.log("简答题信息：" + newshort);
					$.ajax('./user/addshort', {
						method : 'post',
						data : JSON.stringify(newshort),
						contentType : "application/json"
					}).done(function() {
						console.log("添加成功");
						toastr.success('添加成功');
						//刷新表格
						showData();
						//清空数据
//						modal.find('.form-group input').val("");
						modal.find('.input-group textarea').val("");
						difficultlist.find('option').eq(0).attr("selected",true);
						$('#newshort').modal('hide');
					}).fail(function() {
						// 如果响应码不是2打头
						console.log("创建失败");
						toastr.error('添加失败，请重试');
						});
				}else{
					toastr.warning('请完善信息');
				}
				
			});
		}	
	});
	
	//删除科目
	var shortdelcount = 0;
	window.delshort = function(id){
		console.log("id:" + id);
		var shortid ;
		$('#delshort').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++shortdelcount == 1){
				delbutton.click(function() {
					shortid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./user/delshort", {
						method: 'post',
						data : {id : shortid},
					}).done(function() {
						console.log("删除成功");
						toastr.success('删除成功');
						showData();
						//隐藏数据
						$('#delshort').modal('hide');
					}).fail(function() {
						// 如果响应码不是2打头
						console.log("删除失败");
						toastr.error('删除失败，请重试');
						});
					});
				}
			});
	}
	//批量删除
	$('#toolbar6 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var shortsdelcount = 0;
		console.log("长度：" + $('#short-table tbody').find('input:checkbox:checked').length);
		if($('#short-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar6 button').eq(1).attr("data-target","#delshorts");
			checkbox = $('#short-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delshorts').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++shortsdelcount == 1){
					delbutton.click(function() {
						$.ajax("./user/delshorts", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delshorts').modal('hide');
						}).fail(function() {
							// 如果响应码不是2打头
							console.log("删除失败");
							toastr.error('删除失败，请重试');
							});
						});
					}
				});
		}else{
			$('#toolbar6 button').eq(1).attr("data-target","");
			toastr.warning('请勾选需要删除的用户');
		}
	});
	
});
