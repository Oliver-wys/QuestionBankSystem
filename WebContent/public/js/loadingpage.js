$(document).ready(function() {
	$('#submit').click(function(){
		console.log('loading...');
		var account = $('#account').val();
		var password = $('#password').val();
		console.log('loading:',account,password)
		
		var user = {
			account : account,
			password : password
		};
		
		$.ajax('./main',{
			method: 'POST',
			data: JSON.stringify(user),
			contentType: "application/json"
		}).done(function() {
			console.log('成功...');
		}).fail(function(){
			console.log('failed...')
		});
	});
});
