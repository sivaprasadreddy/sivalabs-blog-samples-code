<%@include file="../taglib.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs:New Contact</title>
<script type="text/javascript">

   
    </script>
</head>
<body>
	<div align="center">
	
	<form:form action="newContact" method="post" commandName="contact">
		<c:if test="${errorMsg != null }">
		<span style="color: red">${errorMsg}</span>
		</c:if>
		
		<table style="border: 1; border-collapse: collapse;">
		 
		  <tr>
		    <td>Name*</td>
		    <td><form:input path="name"/> </td>
		    <td><form:errors path="name" cssClass="error"/> </td>
		  </tr>
		  <tr>
		    <td>Picture</td>
		    <td><input type="file" name="picture">  </td>
		  </tr>
		  <tr>
		  	<td colspan="2">
		  		<input type="submit" value="Save">
		  	</td>
		  </tr>
		</table>

	</form:form>
	</div>
</body>
</html>