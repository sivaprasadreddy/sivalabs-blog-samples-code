<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../taglib.jsp" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome</title>
	<style type="text/css">
/*margin and padding on body element
  can introduce errors in determining
  element position and are not recommended;
  we turn them off as a foundation for YUI
  CSS treatments. */
body {
	margin:0;
	padding:0;
}
</style>
	
<link rel="stylesheet" type="text/css" href="resources/yui-2.9.0/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css" href="resources/yui-2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<script type="text/javascript" src="resources/yui-2.9.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="resources/yui-2.9.0/build/connection/connection-min.js"></script>
<script type="text/javascript" src="resources/yui-2.9.0/build/json/json-min.js"></script>
<script type="text/javascript" src="resources/yui-2.9.0/build/element/element-min.js"></script>
<script type="text/javascript" src="resources/yui-2.9.0/build/datasource/datasource-min.js"></script>
<script type="text/javascript" src="resources/yui-2.9.0/build/event-delegate/event-delegate-min.js"></script>
<script type="text/javascript" src="resources/yui-2.9.0/build/datatable/datatable-min.js"></script>

<script type="text/javascript" src="resources/js/phonebook.js"></script>


</head>
<body class="yui-skin-sam">

	<div align="center"><div id="contactSearch">
		<form action="#" method="post">
		
		<table style="border: 1; border-collapse: collapse;">
		 
		  <tr>
		    <td>Name*</td>
		    <td><input type="text" name="searchName" id="searchName"/> </td>
		    <td><input type="button" id="contactSearchBtn" value="Search"></td>
		    <td><input type="button" id="addNewContactBtn" value="AddNew"></td>
		  </tr>
		</table>
	</form>
	</div></div>
	
	<div align="center"><div id="contactList"></div></div>
	
	<div id="newContact" style="display: none;">
	<div align="center">
	
	<form action="newContact" method="post">
		<c:if test="${errorMsg != null }">
		<span style="color: red">${errorMsg}</span>
		</c:if>
		
		<table style="border: 1; border-collapse: collapse;">
		 <tr>
		  	<td colspan="2">
		  		<h3>New Contact Form</h3>
		  	</td>
		  </tr>
		  <tr>
		    <td>FirstName*</td>
		    <td><input type="text" name="firstname"/> </td>
		  </tr>
		  <tr>
		    <td>LastName*</td>
		    <td><input type="text" name="lastname"/> </td>
		  </tr>
		  <tr>
		    <td>Email*</td>
		    <td><input type="text" name="email"/> </td>
		  </tr>
		  <tr>
		    <td>Mobile*</td>
		    <td><input type="text" name="mobile"/> </td>
		  </tr>
		  <tr>
		    <td>Phone*</td>
		    <td><input type="text" name="phone"/> </td>
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

	</form>
	</div>
	</div>
	
	<div id="editContact" style="display: none;">
	<div align="center">
	
	<form  name="updateContactForm" action="updateContact" method="post">
		<c:if test="${errorMsg != null }">
		<span style="color: red">${errorMsg}</span>
		</c:if>
		
		<table style="border: 1; border-collapse: collapse;">
		 <tr>
		  	<td colspan="2">
		  		<h3>Edit Contact Form</h3>
		  	</td>
		  </tr>
		  <tr>
		    <td>Id*</td>
		    <td><input type="text" name="id" readonly="readonly"/> </td>
		  </tr>
		  <tr>
		    <td>FirstName*</td>
		    <td><input type="text" name="firstname"/> </td>
		  </tr>
		  <tr>
		    <td>LastName*</td>
		    <td><input type="text" name="lastname"/> </td>
		  </tr>
		  <tr>
		    <td>Email*</td>
		    <td><input type="text" name="email"/> </td>
		  </tr>
		  <tr>
		    <td>Mobile*</td>
		    <td><input type="text" name="mobile"/> </td>
		  </tr>
		  <tr>
		    <td>Phone*</td>
		    <td><input type="text" name="phone"/> </td>
		  </tr>
		  <tr>
		    <td>DOB*</td>
		    <td><input type="text" name="dob"/> </td>
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

	</form>
	</div>
	</div>
	
<script type="text/javascript">
	
</script>

</body>
</html>