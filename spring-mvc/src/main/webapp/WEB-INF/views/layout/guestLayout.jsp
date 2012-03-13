<%@ include file="../taglib.jsp" %>
<html>
<head>
	<link type="text/css" href="resources/css/style.css" rel="stylesheet" />
	<link type="text/css" href="resources/jquery/css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
	<script type="text/javascript" src="resources/jquery/js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="resources/jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
	
	<decorator:head/>	
</head>
<body>

<div id="mainPanel">

	<div id="headerPanel">
		<%@include file="header.jsp" %>
	</div>
	
	<div id="contentPanel" align="center" style="width: 100%">
		<decorator:body/>
	</div>
	<div id="footerPanel">
		<%@include file="footer.jsp" %>
	</div>
</div>

</body>
</html>