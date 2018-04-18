$('.btn').click(function(){
	console.log('loading...');
	var account = $('#account').val();
	var password = $('#password').val();
	console.log('loading:',account,password)
	
	var user = {
		account : account,
		password : password
	}
	
	$.ajax('.',{
		method : 'POST',
		data : JSON.stringify(user),
		contentType : "application/json"
	}).fail(function(){
		console.log('failed...')
	});
});