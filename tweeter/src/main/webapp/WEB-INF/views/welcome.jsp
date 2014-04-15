<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
<script type="text/javascript">
$(document).ready(function() {
	//console.log("ready!");
  
  function loadMsgs()
  {
    $.getJSON( "messages", function( data ) {
    	 $('#tweetsTbl tbody').empty();
        $.each( data, function( key, val ) {
          $('#tweetsTbl tbody').append('<tr><td>'+val.text+'</td><td>'+val.postedBy.userName+'</td></tr>');
        });   
      });
	}
  
  loadMsgs();
  
  $('#postBtn').click(function(){
    var tweet = $.trim($('#tweetMsg').val());
    var jsonData = {"text": tweet};
	  $.ajax({ 
		    url: "messages", 
		    type: 'POST', 
        /*
		    beforeSend: function(xhr) {  
                xhr.setRequestHeader("Accept", "application/json");  
                xhr.setRequestHeader("Content-Type", "application/json");  
        }, 
        */
		    dataType: 'json', 
		    data: JSON.stringify(jsonData),
		    contentType: 'application/json',
		    //mimeType: 'application/json',
		    success: function(data) { 
		        if(data.status == true){
              $('#tweetMsg').val('');
              loadMsgs();
		        } else {
		        	alert("Error: "+data.message);
		        }
		    },
		    error:function(data,status,er) { 
		        alert("Error: "+er);
		    }
	  });
	  
	});
});
</script>
</head>
<body>

            
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <label class="sr-only" for="exampleInputEmail2">Message</label>
                <textarea id="tweetMsg" class="form-control" rows="5" cols="80" style="width: 800px" maxlength="500"></textarea>
              </div>
              <button id="postBtn" type="button" class="btn btn-default">Submit</button>
            </form>
         <div class="row">
        	<h2>Messages</h2>
        	<table id="tweetsTbl" class="table table-bordered">
        		<thead>
        			<tr class="success">
        				<th>Message</th>
        				<th>Posted By</th>
        			</tr>
        		</thead>
        		<tbody>
              <!-- 
        			<c:forEach var="msg" items="${messages}">
        				<tr>
        					<td>${msg.text}</td>
        					<td>${msg.postedBy.userName}</td>
        				</tr>
        			</c:forEach>
               -->
        		</tbody>
        	</table>
      </div>
</body>
</html>