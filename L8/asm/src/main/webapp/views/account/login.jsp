<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
<h3>LOGIN</h3>
<p><b><i>${message}${param.error}</i></b></p>
<form action="/account/login" method="post">
	<input name="username"  placeholder="Username?">
	<p>
	<input name="password" placeholder="Password?">
	<p>
	<button>Login</button>
</form>
</body>
</html>