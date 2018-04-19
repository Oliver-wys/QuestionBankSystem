<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="/QuestionBankSystem/assets/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="." method="post">
<input type="text" name="account">
<input type="password" name="password">
<button type="button" id="submit">Submit</button>
</form>
<script type="text/javascript">
 $('#submit').click(function() {
	var account = $('input[name="account"]').val();
	var password = $('input[name="password"]').val();
	console.log('...',name,password);
	
	var user = {
			account : account,
			password : password
	}
	
	$.ajax('.',{
		method : 'post',
		data : JSON.stringify(user), 
		/* data : user, */
		contentType: "application/json"
	}).done(function(){
		console.log('...succeed');
	}).fail(function() {
		console.log('...failed');
	});
}); 
</script>
</body>
</html>