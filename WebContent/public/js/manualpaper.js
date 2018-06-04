$(document).ready(function () {
	
	useracademy = $('#user-info input').val();
	var subjectlist9;
	var diflist;
	var menubox = $('.des-box').eq(11).find('.table-box');
	var difname;
	var username;
	var papername;
	var score;
	var time;
	var singlenum;
	var singlescore;
	var multinum;
	var multiscore;
	var completionnum;
	var completionscore;
	var judgenum;
	var judgescore;
	var shortnum;
	var shortscore;
	var checkboxgroup = menubox.find('.checkbox-box');
	var chaptervalue;
	
	subjectbutton = $('.des-box').eq(11).find('.select-group button');
	
	$('.second-row').click(function(){
		secondrow_inf = $('.second-row').eq(8).hasClass("secondchoosen");
		if(secondrow_inf){
			
			username = menubox.find('input').eq(0).attr("value");
			console.log("用户名：" + username);
			
			subjectlist9 = $('.des-box').eq(11).find('select').eq(0);
			diflist = $('.des-box').eq(11).find('select').eq(1);
			
			//获取科目信息
			subjectlist9.empty();
			
			$.get("./user/subjectbyacademy?academyname=" + useracademy, function(data) {
				subjectlist9.append("<option>请选择科目</option>");
				for(var i=0; i < data.length; i++){
					subjectlist9.append("<option value=" + data[i].id + ">" + data[i].name + "</option>");
				}
			});
		}
	});
	
	//找到确认按钮
	
	var count9 = 0;
	subjectbutton.click(function(){
		
		
		
		if(subjectlist9.find("option:selected").attr("value") > 0
				&&diflist.find("option:selected").attr("value") > 0){
			//获得选中的科目
			subjectname = subjectlist9.find("option:selected").text();
			console.log("科目：" + subjectname);
			//获得选中的难度
			difname = diflist.find("option:selected").text();
			console.log("难度：" + difname);
			//获取章节信息
			
			checkboxgroup.empty();
			$('#allcheck').prop("checked",false);
			$.get("./user/chapterbysubject?subjectname=" + subjectname, function(data) {
				for(var i=0; i < data.length; i++){
					checkboxgroup.append("<input value=" + data[i].name + " type=\"checkbox\"><label>" + data[i].name + "</label>");
				}
			});
			menubox.slideDown("slow");
		}else{
			toastr.warning('请选择科目和难度');
		}
	});
	

	//复选框事件
	//全选
	$('#allcheck').click(function(){
		if($('#allcheck').prop("checked")){
			checkboxgroup.find('input:checkbox').each(function() {
				$(this).prop("checked",true);
			});
		}else{
			checkboxgroup.find('input:checkbox').each(function() {
				$(this).prop("checked",false);
			})
		}
	});
	checkboxgroup.click(function(){
		if(checkboxgroup.find('input:checkbox:checked').length == checkboxgroup.find('input:checkbox').length){
			$('#allcheck').prop("checked",true);
		}else{
			$('#allcheck').prop("checked",false);
		}
	});
	
	//提交按钮事件
	menubox.find('.paper-box button').click(function(){
		papername = menubox.find('.paper-box input').eq(0).val();
		score = menubox.find('.paper-box input').eq(1).val();
		time = menubox.find('.paper-box input').eq(2).val();
		singlenum = menubox.find('.paper-box input').eq(3).val();
		singlescore = menubox.find('.paper-box input').eq(4).val();
		multinum = menubox.find('.paper-box input').eq(5).val();
		multiscore = menubox.find('.paper-box input').eq(6).val();
		completionnum = menubox.find('.paper-box input').eq(7).val();
		completionscore = menubox.find('.paper-box input').eq(8).val();
		judgenum = menubox.find('.paper-box input').eq(9).val();
		judgescore = menubox.find('.paper-box input').eq(10).val();
		shortnum = menubox.find('.paper-box input').eq(11).val();
		shortscore = menubox.find('.paper-box input').eq(12).val();
		
		//复选框值
		chaptervalue = "";
		checkboxgroup.find('input:checkbox:checked').each(function(i) {
			if(i == checkboxgroup.find('input:checkbox:checked').length - 1){
				chaptervalue += $(this).val();
			}else{
				chaptervalue += $(this).val() + "|";
			}
		})
		if(chaptervalue == "" || papername == "" || score == "" || time == ""){
			toastr.warning('请完善必要信息');
		}else{
			var testInf={
					name : papername,
					academyName : useracademy,
					subjectName : subjectname,
					userName : username,
					time : time,
					score : score,
           			}
			
			var paperForm={
					academyName : useracademy,
					subjectName : subjectname,
					chapterName : chaptervalue,
					singleNum : singlenum,
					singleScore : singlescore,
					multiNum : multinum,
					multiScore : multiscore,
					judgeNum : judgenum,
					judgeScore : judgescore,
					completionNum : completionnum,
					completionScore : completionscore,
					shortNum : shortnum,
					shortScore : shortscore,
					score : score,
					time : time,
					dif_coefficient : difname
			}
			var map ={
					testInf : testInf,
					paperForm : paperForm
			}
			console.log("多选题信息：" + map);
			$.ajax('./user/manualpaper', {
				method : 'post',
				data : JSON.stringify(map),
				contentType : "application/json"
			}).done(function() {
				console.log("添加成功");
				toastr.success('添加成功');
				//清空数据
				menubox.find('.form-row input').val("");
				menubox.find('.input-group input').val("");
				menubox.find('input:checkbox:checked').prop("checked",false);
				diflist.find('option').eq(0).prop("selected",true);
				subjectlist9.find('option').eq(0).prop("selected",true);
				window.open("./user/testpaper");
			}).fail(function() {
				// 如果响应码不是2打头
				console.log("创建失败");
				toastr.error('添加失败，请重试');
				});
		}
	});
	
	
	
});