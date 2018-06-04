$(document).ready(function () {

	function showData() {
		$('#chapter-table').bootstrapTable('refresh');
	}
	
	$.get("./user/allchapter", function(result) {
		console.log(result);
		$("#chapter-table").bootstrapTable({ // 对应table标签的id
	        url: "./user/allchapter", // 获取表格数据的url
	        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
	        striped: true,  //表格显示条纹，默认为false
	        pagination: true, // 在表格底部显示分页组件，默认false
//	        pageList: [5], // 设置页面可以显示的数据条数
	        pageSize: 7, // 页面数据条数
	        dataType: "json",
	        method: 'get',
	        data: result,
	        cache: false,
	        sidePagination: 'client', // 设置为服务器端分页
//	        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
//	            return {
//	            	limit: params.limit, // 每页要显示的数据条数
//	                offset: params.offset, // 每页显示数据的开始行号
//	            };
//	        },
//	        responseHandler : function(res){
//	        	return res;
//	        },
	        sortName: 'id', // 要排序的字段
        columns: [{
        	checkbox: true,
        	align: 'center',
        },{
            field: 'id', // 返回json数据中的name
            title: '编号', // 表格表头显示文字
            align: 'center',
            valign: 'middle',
            width: 321,
        }, {
            field: 'name',
            title: '科目名',
            align: 'center',
            valign: 'middle',
            width: 321,
        },{
            title: "操作",
            align: 'center',
            valign: 'middle',
            width: 160, // 定义列的宽度，单位为像素px
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
});
