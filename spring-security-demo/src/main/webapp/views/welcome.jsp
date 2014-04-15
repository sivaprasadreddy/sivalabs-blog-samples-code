<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
Welcome
<c:url var="logoutUrl" value="/logout"/>
<li>
<a
href="${logoutUrl}">Logout</a>
</li>

</body>
</html>