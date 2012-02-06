<%@ include file="../taglib.jsp" %>

<html>
<head>
	<title><decorator:title default="Welcome!" /></title>
	
	<sl:includeResource type="css" path="resources/css/style.css"/>

	<decorator:head/>
	
	
</head>
<body class="yui-skin-sam">
<div align="center">
<div class="site">
	<table class="tbl">
		<tbody>		  
		 <tr>
		 	<td colspan="2" height="70" class="header">
		 		<%@include file="header.jsp" %>
		 	</td>
		 </tr>	
		 <tr>
		 	<td colspan="2" height="20"  class="userBanner">
		 		<%@include file="userBanner.jsp" %>
		 	</td>
		 </tr>			 
		 <tr>
		 	<td width="15%" valign="top" class="nav">
		 		<%@include file="navigation.jsp" %>
		 	</td>
		    <td valign="top">
		    	<table class="tbl" style="height: 600px; overflow: scroll;">
		    		<tr>
		    			<td valign="top" class="workPanel">
		    				<decorator:body/>
		    			</td>
		    		</tr>
		    	</table>
		    </td>
		 </tr>
		 <tr class="footer" height="25">
	    	<td colspan="2">
	    		<%@include file="footer.jsp" %>
	   		 </td>
		 </tr>
		</tbody>
	</table>	
</div>
</div>
</body>
</html>