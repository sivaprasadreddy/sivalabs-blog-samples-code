<%@include file="taglib_includes.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript" src="js/contacts.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchContacts.do" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
			<tr>
				<td>Enter Contact Name</td> 
				<td><input type="text" name="name"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New Contact" onclick="javascript:go('saveContact.do');"/>
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>Name</th>			
			<th>Address</th>	
			<th>Mobile</th>
			<th></th>
		</tr>
		<c:if test="${empty SEARCH_CONTACTS_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_CONTACTS_RESULTS_KEY}">
			<c:forEach var="contact" items="${SEARCH_CONTACTS_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${contact.id}"></c:out></td>
				<td><c:out value="${contact.name}"></c:out></td>
				<td><c:out value="${contact.address}"></c:out> </td>
				<td><c:out value="${contact.mobile}"></c:out></td>
				<td>
					&nbsp;<a href="updateContact.do?id=${contact.id}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteContact('deleteContact.do?id=${contact.id}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>