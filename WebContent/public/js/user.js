$(document).ready(function() {
    console.log("dddddddd")

     $.ajaxSetup ({
         cache: false //关闭AJAX缓存
     });
    var secondrow_inf;
    var useracademy;
	var subjectname;
	var subjectbutton;
    toastr.options.positionClass = 'toast-bottom-right';
    /*
    操作选项下拉
     */
    //$("#manage").click(function() {
    //    if ($(this).hasClass("choosen")) {
    //        $(this).removeClass("choosen");
    //        $("[num = '1']").slideUp("slow");
    //    } else{
    //        $(this).addClass("choosen");
    //        $("[num = '1']").slideDown("slow");
    //    }
    //});
    var description = "";
    var index = "";
    $(".row").click(function(){
        //拿到被选中的下标
        index = $(this).index();
        $(".second-row").removeClass("secondchoosen");
        if($(this).hasClass("choosen")){
            $(this).removeClass("choosen");
            $("[des='"+$(this).attr("des")+"'][class='second-row']").fadeOut("slow");
            //$(".des-box").eq(index).fadeOut("slow");
        }else{
            $(this).addClass("choosen").siblings().removeClass("choosen");
            $("[des='"+$(this).attr("des")+"'][class='second-row']").fadeIn("slow");
            $("[des!='"+$(this).attr("des")+"'][class='second-row']").fadeOut("slow");
            //$(".des-box").eq(index).fadeIn("slow").siblings().fadeOut("slow");
        }
    });

    var secondIndex;
    $(".second-row").click(function(){
        secondIndex = $(this).index();
        console.log("secondIndex:"+secondIndex);
        if($(this).hasClass("secondchoosen")){
            $(this).removeClass("secondchoosen");
            $(".des-box").eq(secondIndex).fadeOut("slow");
        }else{
            $(this).addClass("secondchoosen").siblings().removeClass("secondchoosen");
            $(".des-box").eq(secondIndex).fadeIn("slow").siblings().fadeOut("slow");
        }
    });
    
  //修改密码
    var changepasswordcount = 0;
    $('#changepassword').on('show.bs.modal', function (event) {
    	var modal = $(this);
    	var oldpassword ;
    	var newpassword;
    	var confirmpassword;
    	var confirmbutton = modal.find('.modal-footer button').eq(1);
    	if(++changepasswordcount == 1){
    		confirmbutton.click(function() {
    			oldpassword = modal.find(".form-group input").eq(0).val();
    			newpassword = modal.find(".form-group input").eq(1).val();
    			confirmpassword = modal.find(".form-group input").eq(2).val();
    			console.log("oldpassword:" + oldpassword);
    			console.log("newpassword:" + newpassword);
    			console.log("confirmpassword:" + confirmpassword);
    			if(oldpassword == "" || newpassword == ""|| confirmpassword == ""){
    				toastr.warning('请完成信息填写');
    			}else if(newpassword != confirmpassword){
    				toastr.warning('新密码两次输入不同');
    			}else{
    				var password ={
    						oldpassword : oldpassword,
    						newpassword : newpassword,
    				}
    				$.ajax("./user/changepassword", {
    					method: "post",
//    					dataType: "text",
    					data: JSON.stringify(password),
    					contentType: "application/json",
//    					success: function(data){
//    						console.log("data:" + data);
//    					}
    				}).done(function(data) {
						console.log("data:" + data);
						if(data == 1){
							toastr.success('修改成功');
							modal.find('.form-group input').val("");
							$('#changepassword').modal('hide');
						}else{
							toastr.warning('原密码错误');
						}
						//清空数据
					}).fail(function() {
						// 如果响应码不是2打头
						toastr.error('修改失败，请重试');
						});
    			}
    		});
    	}
    	console.log("用户的密码：" + oldpassword);
    });



    //修改用户信息
    var changeinfcount = 0;
    $('#changeinf').on('show.bs.modal', function (event) {
    	var modal = $(this);
    	var id = $('.userinf-box input').val();
    	var name;
    	var gender;
    	var phonenum;
    	var confirmbutton = modal.find('.modal-footer button').eq(1);
    	if(++changeinfcount == 1){
    		confirmbutton.click(function() {
    			name = modal.find(".form-group input").eq(0).val();
    			gender = modal.find(".form-group input").eq(1).val();
    			phonenum = modal.find(".form-group input").eq(2).val();
    			var userinf ={
						id :id,
    					name : name,
						gender : gender,
						phoneNum : phonenum
				}
    			console.log("用户信息：" + userinf);
				$.ajax("./user/changeinf", {
					method: "post",
					data: JSON.stringify(userinf),
					contentType: "application/json",
				}).done(function(data) {
					toastr.success('修改成功');
					$('.list-group span').eq(2).text(name);
					$('.list-group span').eq(3).text(gender);
					$('.list-group span').eq(4).text(phonenum);
					$('#changeinf').modal('hide');
					//清空数据
				}).fail(function() {
					// 如果响应码不是2打头
					toastr.error('修改失败，请重试');
					});
    		});
    	}
    	
    });
});