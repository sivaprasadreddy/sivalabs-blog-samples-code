<%@include file="taglib.jsp" %>
<html>
<head>

<link rel="stylesheet" type="text/css" href="resources/flexgrid-1.1/css/flexigrid.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="resources/flexgrid-1.1/js/flexigrid.js"></script>
</head>
<body>
 <div>
 	<p><a href="./">Home</a>
 </div>
	<form action="showUsers" method="post">		
			<table>
			<tr>
				<td>Enter User Name</td> 
				<td><input type="text" name="name"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					
				</td>
			</tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1">
		<tr bgcolor="lightblue" style="border: 1; border-collapse: collapse;">
			<th>UserId</th>
			<th>UserName</th>			
			<th>Email</th>	
			<th>DOB</th>
			
		</tr>
		<c:if test="${empty USERS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty USERS_KEY}">
			<c:forEach var="user" items="${USERS_KEY}">		
		    <tr style="border: 1; border-collapse: collapse;">
				<td><c:out value="${user.userId}"></c:out></td>
				<td><c:out value="${user.userName}"></c:out></td>
				<td><c:out value="${user.email}"></c:out> </td>
				<td><c:out value="${user.dob}"></c:out></td>
				
			</tr>
			</c:forEach>
		</c:if>				
	</table>
	
<table id="flex1" style="display:none"></table>
<script type="text/javascript">
$("#flex1").flexigrid({
        url: 'showUsersAjax',
        dataType: 'json',
        colModel : [
                {display: 'UserId', name : 'userId', width : 40, sortable : true, align: 'center'},
                {display: 'UserName', name : 'userName', width : 130, sortable : true, align: 'left'}
                ],
        	searchitems : [
                {display: 'userName', name : 'userName'}
                ],
        sortname: "userName",
        sortorder: "asc",
        usepager: true,
        title: 'Users',
       // useRp: true,
       // rp: 15,
       // showTableToggleBtn: true,
        width: 700,
        //onSubmit: addFormData,
        height: 200
});

//This function adds paramaters to the post of flexigrid. You can add a verification as well by return to false if you don't want flexigrid to submit                   

/*
function addFormData(){
        //passing a form object to serializeArray will get the valid data from all the objects, but, if the you pass a non-form object, you have to specify the input elements that the data will come from
        var dt = $('#sform').serializeArray();
        $("#flex1").flexOptions({params: dt});
        return true;
}
        
$('#sform').submit(function (){
        $('#flex1').flexOptions({newp: 1}).flexReload();
        return false;
});
*/
</script>

</body>
</html>