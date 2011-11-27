<%@include file="taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form action="login.htm" method="post" commandName="login">
		<p><span style="color: red">${ERROR}</span> </p>
		<p>UserId : <form:input path="userId"/> </p>
		<p>Password : <form:password path="password"/> </p>
		<p><input type="submit" value="Login"></p>
	</form:form>
</body>
</html>