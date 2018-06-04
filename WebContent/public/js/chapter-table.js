$(document).ready(function () {

	function showData() {
		$('#chapter-table').bootstrapTable('refresh');
	}
	useracademy = $('#user-info input').val();
	var toolbar1;
	var subjectlist1;
	$('.second-row').click(function(){
		console.log("所属学院：" + useracademy);
		secondrow_inf = $('.second-row').eq(0).hasClass("secondchoosen");
		if(secondrow_inf){
			subjectlist1 = $('.des-box').eq(1).find('select');
			toolbar1 = $('#toolbar1');
			//获取科目信息
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist1.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist1.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			//找到确认按钮
			subjectbutton = $('.des-box').eq(1).find('.select-group button');
			var count1 = 0;
			subjectbutton.click(function(){
				if(subjectlist1.find("option:selected").attr("value") > 0){
					//获得选中的科目
					subjectname = subjectlist1.find("option:selected").text();
					//显示查找的章节信息
					$("#chapter-table").bootstrapTable('destroy');
					console.log("章节表初始化：" + secondrow_inf);
					$.get("./user/chapterbysubject?subjectname=" + subjectname, function(result) {
						toolbar1.css("display","");
						$("#chapter-table").bootstrapTable({ // 对应table标签的id
					        url: "./user/chapterbysubject?subjectname=" + subjectname, // 获取表格数据的url
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
				            	title: '章节名',
				            	align: 'center',
				            	valign: 'middle',
				            	width: 852,
				            },{
				            	title: "操作",
				            	align: 'center',
				            	valign: 'middle',
				            	width: 100, // 定义列的宽度，单位为像素px
				            	formatter: function (value, row, index) {
				            		var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delchapter" onclick="delchapter(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
				            		var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#delacademy" onclick="edit(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>';
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
						if(++count1 == 1)
						toastr.warning('请选择科目');
						}
				});
			}else{
				if(subjectlist1 != null){
					subjectlist1.empty();
					toolbar1.css("display","none");
				}
				$("#chapter-table").bootstrapTable('destroy');
				console.log("章节表销毁：" + secondrow_inf)
				}
		});
	
	var chapteraddcount = 0;
	var chapterdelcount = 0;
	var chapterdelscount = 0;
	//添加章节信息
	$('#newchapter').on('show.bs.modal', function (event) {
		  var modal = $(this);
		  var newchaptername;
		  var newchapter;
		  var addbutton = modal.find('.modal-footer button').eq(1);
			
		  if (++chapteraddcount == 1) {
			  addbutton.click(function(){
				  newchaptername = modal.find('.form-group input').val();
				  	if(newchaptername == ""){
				  		toastr.warning('请输入章节名');
				  	}else{
				  		console.log(newchaptername);
				  		newchapter = {
				  				name : newchaptername,
				  				academyName : useracademy,
				  				subjectName : subjectname
				  				
				  				}
				  		console.log(newchapter);
				  		$.ajax('./user/addchapter', {
							method : 'post',
							data : JSON.stringify(newchapter),
							contentType : "application/json"
						}).done(function() {
							console.log("添加成功");
							toastr.success('添加成功');
							showData();
							//清空数据
							modal.find('.form-group input').val("");
							$('#newchapter').modal('hide');
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
	window.delchapter = function(id){
		console.log("id:" + id);
		var chapterid;
		$('#delchapter').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++chapterdelcount == 1){
				delbutton.click(function() {
					chapterid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./user/delchapter", {
						method: 'post',
						data : {id : chapterid},
					}).done(function() {
						console.log("删除成功");
							toastr.success('删除成功');
						showData();
						//清空数据
						$('#delchapter').modal('hide');
					}).fail(function() {
						// 如果响应码不是2打头
						
						console.log("删除失败");
						
						toastr.error('删除失败，请重试');
						});
					});
				}
			});
	}
	//批量删除章节
	$('#toolbar1 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var chaptersdelcount = 0;
		console.log("长度：" + $('#chapter-table tbody').find('input:checkbox:checked').length);
		if($('#chapter-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar1 button').eq(1).attr("data-target","#delchapters");
			checkbox = $('#chapter-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delchapters').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++chaptersdelcount == 1){
					delbutton.click(function() {
						$.ajax("./user/delchapters", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delchapters').modal('hide');
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
	
	
});
