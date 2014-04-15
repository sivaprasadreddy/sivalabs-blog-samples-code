<!DOCTYPE html>

<%@ include file="taglib.jsp" %>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SivaLabs</title>
        
        <script type="text/javascript" src='<spring:url value="resources/jquery/jquery-1.10.2.js"/>'></script>
        <link rel="stylesheet" href='<spring:url value="resources/bootstrap/css/bootstrap.min.css"/>' />
        <link rel="stylesheet" href='<spring:url value="resources/bootstrap/css/bootstrap-theme.min.css"/>' />
        <script type="text/javascript" src='<spring:url value="resources/bootstrap/js/bootstrap.min.js"/>'></script>
        <link rel="stylesheet" href='<spring:url value="resources/css/styles.css"/>' />
        <script type="text/javascript" src='<spring:url value="resources/js/app.js"/>'></script>
        
        <decorator:head/>        
</head>
<body>

 <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="welcome">SivaLabs</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="welcome">Home</a></li>
            <li><a href="admin">Administration</a></li>
            <li><a href="contact">Contact</a></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->
    
    
    <div class="container">    
                 
          <div class="row">
                  <div class="span12">
                    <decorator:body/>
                  </div>
          </div>
    
    </div>
</body>
</html>