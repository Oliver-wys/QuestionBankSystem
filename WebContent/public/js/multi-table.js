$(document).ready(function () {

	function showData() {
		$('#multi-table').bootstrapTable('refresh');
	}
	useracademy = $('#user-info input').val();
	var subjectlist3;
	var toolbar3;
	$('.second-row').click(function(){
		console.log("所属学院：" + useracademy);
		secondrow_inf = $('.second-row').eq(2).hasClass("secondchoosen");
		if(secondrow_inf){
			subjectlist3 = $('.des-box').eq(4).find('select').eq(0);
			toolbar3 = $('#toolbar3');
			//获取科目信息
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist3.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist3.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			//找到确认按钮
			subjectbutton = $('.des-box').eq(4).find('.select-group button');
			var count3 = 0;
			subjectbutton.click(function(){
				if(subjectlist3.find("option:selected").attr("value") > 0){
					//获得选中的科目
					subjectname = subjectlist3.find("option:selected").text();
					//显示查找的章节信息
					$("#multi-table").bootstrapTable('destroy');
					console.log("多选表初始化:" + secondrow_inf);
					$.get("./user/multibysubject?subjectname=" + subjectname, function(result) {
						toolbar3.css("display","");
						$("#multi-table").bootstrapTable({ // 对应table标签的id
					        url: "./user/multibysubject?subjectname=" + subjectname, // 获取表格数据的url
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
					            title: '难度系数', // 表格表头显示文字
					            align: 'center',
					            valign: 'middle',
					            width: 45,
					        },{
					            field: 'body', // 返回json数据中的name
					            title: '题干', // 表格表头显示文字
					            align: 'center',
					            valign: 'middle',
					            width: 407,
					            overflow: 'hidden'
					        },{
					            field: 'optionA',
					            title: 'A',
					            align: 'center',
					            valign: 'middle',
					            width: 60,
					        },{
					            field: 'optionB',
					            title: 'B',
					            align: 'center',
					            valign: 'middle',
					            width: 60,
					        },{
					            field: 'optionC',
					            title: 'C',
					            align: 'center',
					            valign: 'middle',
					            width: 60,
					        },{
					            field: 'optionD',
					            title: 'D',
					            align: 'center',
					            valign: 'middle',
					            width: 60,
					        },{
					            field: 'optionE',
					            title: 'E',
					            align: 'center',
					            valign: 'middle',
					            width: 60,
					        },{
					            field: 'answer',
					            title: '答案',
					            align: 'center',
					            valign: 'middle',
					            width: 70,
					        },{
					            title: "操作",
					            align: 'center',
					            valign: 'middle',
					            width: 80, // 定义列的宽度，单位为像素px
					            formatter: function (value, row, index) {
					                var delbtn = '<button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delmulti" onclick="delmulti(\'' + row.id + '\')"><span class="glyphicon glyphicon-remove"></span></button>';
					                var edibtn = '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#editmulti" onclick="editmulti(\'' + row.id + '\')"><span class="glyphicon glyphicon-pencil"></span></button>'
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
					if(++count3 == 1)
					toastr.warning('请选择科目');
				}
			});
			
		}else{
			if(subjectlist3 != null){
				subjectlist3.empty();
				toolbar3.css("display","none");
			}
			console.log("多选表销毁：" + secondrow_inf);
			$("#multi-table").bootstrapTable('destroy');
		}
	});
	
	
	//添加科目
	var multiaddcount = 0;
	$('#newmulti').on('show.bs.modal', function (event) {
		var modal = $(this);
		var chapterlist = modal.find('select').eq(0);
		var difficultlist;
		var answerbox;
		var questionbody;
		var chaptername;
		var difficultname;
//		var checked = false;
		var answer;
		var optionA;
		var optionB;
		var optionC;
		var optionD;
		var optionE;
		
		var addbutton = modal.find('.modal-footer button').eq(1);
			console.log("多选表添加章节");
			chapterlist.empty();
			$.get("./user/chapterbysubject?subjectname=" + subjectname, function(data) {
				chapterlist.append("<option> ---请选择--- </option>");
				for(var i=0; i < data.length; i++){
					chapterlist.append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
				}
			});
			
			if(++multiaddcount == 1){
			addbutton.click(function(){
				answer = "";
				//拿到单选题数据
				chapterlist = modal.find('select').eq(0);
				difficultlist = modal.find('select').eq(1);
				answerbox = modal.find('input:checkbox:checked');
				console.log("答案框长度：" + answerbox.length);
				answerbox.each(function(i, element) {
					if(i == answerbox.length - 1){
						answer = answer + $(this).val();
					}else{
						answer = answer + $(this).val() + "|";						
					}
				})
				console.log("答案：" + answer);
				
				questionbody = modal.find('.input-group textarea').val();
				optionA = modal.find('.input-group input').eq(0).val();
				optionB = modal.find('.input-group input').eq(1).val();
				optionC = modal.find('.input-group input').eq(2).val();
				optionD = modal.find('.input-group input').eq(3).val();
				optionE = modal.find('.input-group input').eq(4).val();
				
				if(chapterlist.find("option:selected").attr("value") > 0 
						&& difficultlist.find("option:selected").attr("value") > 0
						&& questionbody != ""
							&& answer != ""){
					chaptername = chapterlist.find("option:selected").text();
					difficultname = difficultlist.find("option:selected").text();
					var newmulti  = {
							academyName : useracademy,
							subjectName : subjectname,
							chapterName : chaptername,
							dif_coefficient : difficultname,
							body : questionbody,
							optionA : optionA,
							optionB : optionB,
							optionC : optionC,
							optionD : optionD,
							optionE : optionE,
							answer : answer
					}
					console.log("多选题信息：" + newmulti);
					$.ajax('./user/addmulti', {
						method : 'post',
						data : JSON.stringify(newmulti),
						contentType : "application/json"
					}).done(function() {
						console.log("添加成功");
						toastr.success('添加成功');
						//刷新表格
						showData();
						//清空数据
						modal.find('.form-group input').val("");
						modal.find('.input-group textarea').val("");
						chapterlist.find('option').eq(0).attr("selected",true);
						difficultlist.find('option').eq(0).attr("selected",true);
						answerbox.each(function(i) {
							$(this).prop("checked", false);
						})
						$('#newmulti').modal('hide');
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
	var multidelcount = 0;
	window.delmulti = function(id){
		console.log("id:" + id);
		var multiid ;
		$('#delmulti').on('show.bs.modal', function (event){
			var modal = $(this);
			modal.find('.modal-content h5').attr("rowid",id);
			var delbutton = modal.find('.modal-footer button').eq(1);
			if(++multidelcount == 1){
				delbutton.click(function() {
					multiid = modal.find('.modal-content h5').attr("rowid");
					$.ajax("./user/delmulti", {
						method: 'post',
						data : {id : multiid},
					}).done(function() {
						console.log("删除成功");
						toastr.success('删除成功');
						showData();
						//隐藏数据
						$('#delmulti').modal('hide');
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
	$('#toolbar3 button').eq(1).click(function(){
		console.log("找到了");
		var checkbox;
		var ids = new Array();
		var multisdelcount = 0;
		console.log("长度：" + $('#multi-table tbody').find('input:checkbox:checked').length);
		if($('#multi-table tbody').find('input:checkbox:checked').length > 0){
			$('#toolbar3 button').eq(1).attr("data-target","#delmultis");
			checkbox = $('#multi-table tbody').find('input:checkbox:checked');
			
			checkbox.each(function(i) {
				ids[i] = $(this).parent().next().text();
			})
			console.log(ids);
			
			$('#delmultis').on('show.bs.modal', function (event){
				var modal = $(this);
				var delbutton = modal.find('.modal-footer button').eq(1);
				if(++multisdelcount == 1){
					delbutton.click(function() {
						$.ajax("./user/delmultis", {
							method: 'post',
							data : JSON.stringify(ids),
							contentType : "application/json"
						}).done(function() {
							console.log("删除成功");
								toastr.success('删除成功');
							showData();
							//隐藏数据
							$('#delmultis').modal('hide');
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
