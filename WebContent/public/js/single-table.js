$(document).ready(function () {

	function showData() {
		$('#single-table').bootstrapTable('refresh');
	}
	
	
	useracademy = $('#user-info input').val();
	var toolbar2;
	var subjectlist2;
	$('.second-row').click(function(){
		console.log("所属学院：" + useracademy);
		secondrow_inf = $('.second-row').eq(1).hasClass("secondchoosen");
		if(secondrow_inf){
			subjectlist2 = $('.des-box').eq(3).find('select').eq(0);
			toolbar2 = $('#toolbar2');
			//获取科目信息
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist2.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist2.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			//找到确认按钮
			subjectbutton = $('.des-box').eq(3).find('.select-group button');
			var count2 = 0;
			subjectbutton.click(function(){
				if(subjectlist2.find("option:selected").attr("value") > 0){
					//获得选中的科目
					subjectname = subjectlist2.find("option:selected").text();
					//显示查找的章节信息
					$("#single-table").bootstrapTable('destroy');
					console.log("单选表初始化:" + secondrow_inf);
					$.get("./user/singlebysubject?subjectname=" + subjectname, function(result) {
						toolbar2.css("display","");
						$("#single-table").bootstrapTable({ // 对应table标签的id
					        url: "./user/singlebysubject?subjectname=" + subjectname, // 获取表格数据的url
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
				            field: 'chapterName', // 返回json数据中的name
				            title: '章节', // 表格表头显示文字
				            align: 'center',
				            valign: 'middle',
				            width: 65,
				        },{
				            field: 'dif_coefficient', // 返回json数据中的name
				            title: '难度', // 表格表头显示文字
				            align: 'center',
				            valign: 'middle',
				            width: 45,
				        },{
				            field: 'body', // 返回json数据中的name
				            title: '题干', // 表格表头显示文字
				            align: 'center',
				            valign: 'middle',
				            width: 472,
				            overflow: 'hidden'
				        },{
				            field: 'optionA',
				            title: 'A',
				            align: 'center',
				            valign: 'middle',
				            width: 65,
				        },{
				            field: 'optionB',
				            title: 'B',
				            align: 'center',
				            valign: 'middle',
				            width: 65,
				        },{
				            field: 'optionC',
				            title: 'C',
				            align: 'center',
				            valign: 'middle',
				            width: 65,
				        },{
				            field: 'optionD',
				            title: 'D',
				            align: 'center',
				            valign: 'middle',
				            width: 65,
				        },{
				            field: 'answer',
				            title: '答案',
				            align: 'center',
				            valign: 'middle',
				            width: 45,
				        },{
				            title: "操作",
				            align: 'center',
				            valign: 'middle',
				            width: 80, // 定义列的宽度，单位为像素px
				            formatter: function (value, row, index) {
				                var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delsingle" onclick="delsingle(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
				                var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#editsingle" onclick="editsingle(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>'
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
					if(++count2 == 1)
					toastr.warning('请选择科目');
				}
			});
			
		}else{
			if(subjectlist2 != null){
				subjectlist2.empty();
				toolbar2.css("display","none");
			}
			console.log("单选表销毁：" + secondrow_inf);
			$("#single-table").bootstrapTable('destroy');
		}
	});
	
	
	//添加科目
	var singleaddcount = 0;
	$('#newsingle').on('show.bs.modal', function (event) {
		var modal = $(this);
		var chapterlist = modal.find('select').eq(0);
		var difficultlist;
		var answerlist;
		var questionbody;
		var chaptername;
		var difficultname;
		var answername;
		var optionA;
		var optionB;
		var optionC;
		var optionD;
		
		var addbutton = modal.find('.modal-footer button').eq(1);
			console.log("单选表添加章节");
			chapterlist.empty();
			$.get("./user/chapterbysubject?subjectname=" + subjectname, function(data) {
				chapterlist.append("<option> ---请选择--- </option>");
				for(var i=0; i < data.length; i++){
					chapterlist.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			
			if(++singleaddcount == 1){
			addbutton.click(function(){
				//拿到单选题数据
				chapterlist = modal.find('select').eq(0);
				difficultlist = modal.find('select').eq(1);
				answerlist = modal.find('select').eq(2);
				
				questionbody = modal.find('.input-group textarea').val();
				optionA = modal.find('.input-group input').eq(0).val();
				optionB = modal.find('.input-group input').eq(1).val();
				optionC = modal.find('.input-group input').eq(2).val();
				optionD = modal.find('.input-group input').eq(3).val();
				
				if(chapterlist.find("option:selected").attr("value") > 0 
						&& difficultlist.find("option:selected").attr("value") > 0
						&& answerlist.find("option:selected").attr("value") > 0
						&& questionbody != ""){
					chaptername = chapterlist.find("option:selected").text();
					difficultname = difficultlist.find("option:selected").text();
					answername = answerlist.find("option:selected").text();
					console.log("academyname:" + useracademy);
					console.log("subjectname:" + subjectname);
					var newsingle  = {
							academyName : useracademy,
							subjectName : subjectname,
							chapterName : chaptername,
							dif_coefficient : difficultname,
							body : questionbody,
							optionA : optionA,
							optionB : optionB,
							optionC : optionC,
							optionD : optionD,
							answer : answername
					}
					console.log("单选题信息：" + newsingle);
					$.ajax('./user/addsingle', {
						method : 'post',
						data : JSON.stringify(newsingle),
						contentType : "application/json"
					}).done(function() {
						console.log("添加成功");
						toastr.success('添加成功');
						//刷新表格
						showData();
						//清空数据
						modal.find('.form-group input').val("");
						modal.find('.input-group textarea').val("");
						difficultlist.find('option').eq(0).prop("selected",true);
						answerlist.find('option').eq(0).prop("selected",true);
						$('#newsingle').modal('hide');
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
	var singledelcount = 0;
	window.delsingle = function(id){
		console.log("id:" + id);
		var singleid ;
		$('#delsingle').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++singledelcount == 1){
				delbutton.click(function() {
					singleid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./user/delsingle", {
						method: 'post',
						data : {id : singleid},
					}).done(function() {
						console.log("删除成功");
						toastr.success('删除成功');
						showData();
						//隐藏数据
						$('#delsingle').modal('hide');
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
	$('#toolbar2 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var singlesdelcount = 0;
		console.log("长度：" + $('#single-table tbody').find('input:checkbox:checked').length);
		if($('#single-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar2 button').eq(1).attr("data-target","#delsingles");
			checkbox = $('#single-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delsingles').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++singlesdelcount == 1){
					delbutton.click(function() {
						$.ajax("./user/delsingles", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delsingles').modal('hide');
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
