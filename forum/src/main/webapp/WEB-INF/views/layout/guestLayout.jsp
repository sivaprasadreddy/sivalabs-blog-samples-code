<!DOCTYPE html>

<%@ include file="../taglib.jsp" %>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SivaLabs : Forum</title>
        <%@ include file="../fragments/assets.jspf" %>
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
          <a class="navbar-brand" href="">SivaLabs</a>
        </div>
      </div><!-- /.container -->
    </div><!-- /.navbar -->
    
    
    <div class="container">    
                 
          <div class="row">
                  <div class="col-md-12">
                    <decorator:body/>
                  </div>
          </div>
    
    </div>
</body>
</html>