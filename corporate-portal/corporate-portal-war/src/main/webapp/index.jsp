<html>
<body>
<form action="echoServlet">
Enter Name : <input type="text" name="username">
<input type="submit" value="Submit">
</form>
<h2>Hello <%=(String)request.getAttribute("ECHO") %> ${ECHO}!!!</h2>
</body>
</html>
