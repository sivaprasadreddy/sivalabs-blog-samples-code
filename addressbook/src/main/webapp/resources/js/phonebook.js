YAHOO.namespace("com.sivalabs.phonebook");


YAHOO.com.sivalabs.phonebook.editContact= function(id){

	YAHOO.util.Dom.setStyle('newContact', 'display', "none"); 
	YAHOO.util.Dom.setStyle('editContact', 'display', "block"); 
	
	var callbacks = {
		    // Successful XHR response handler
		    success : function (o) {
		        var contactJSON = "";

		        // Use the JSON Utility to parse the data returned from the server
		        try {
		        	contactJSON = YAHOO.lang.JSON.parse(o.responseText);
		        }
		        catch (x) {
		            alert("JSON Parse failed!");
		            return;
		        }
		        var contact = contactJSON.data;
		        //alert(contact);
		        document.updateContactForm.id.value=contact.id;
		        document.updateContactForm.firstname.value=contact.firstname;
		        document.updateContactForm.lastname.value=contact.lastname;
		        document.updateContactForm.email.value=contact.email;
		        document.updateContactForm.phone.value=contact.phone;
		        document.updateContactForm.mobile.value=contact.mobile;
		        document.updateContactForm.dob.value=contact.dob;
		    }

		};
	
	YAHOO.util.Connect.asyncRequest('GET',"getContactJSON?id="+id, callbacks); 
};

YAHOO.com.sivalabs.phonebook.deleteContact = function(id){
	var callbacks = {
		    success : function (o) {
		        var msg = "";

		        try {
		        	msg = YAHOO.lang.JSON.parse(o.responseText);
		        }
		        catch (x) {
		            alert("JSON Parse failed!");
		            return;
		        }
		        alert(msg.data);
		        YAHOO.util.Dom.setStyle('editContact', 'display', "none"); 
		    	YAHOO.util.Dom.setStyle('newContact', 'display', "none"); 
		    	YAHOO.com.sivalabs.phonebook.loadContacts();
		    }

		};
	
	YAHOO.util.Connect.asyncRequest('GET',"deleteContact?id="+id, callbacks); 
};

YAHOO.com.sivalabs.phonebook.addNewContact = function(id){
	YAHOO.util.Dom.setStyle('editContact', 'display', "none"); 
	YAHOO.util.Dom.setStyle('newContact', 'display', "block"); 
};

YAHOO.com.sivalabs.phonebook.loadContacts = function() {
    //alert('com.sivalabs.phonebook.loadContacts');
	YAHOO.widget.DataTable.formatEditLink = function(elLiner, oRecord, oColumn, oData) {
        //var id = YAHOO.lang.escapeHTML(oData);
		var links = "<a href=\"javascript:YAHOO.com.sivalabs.phonebook.editContact('" + oData + "')\">Edit</a>&nbsp;"+
		"<a href=\"javascript:YAHOO.com.sivalabs.phonebook.deleteContact('" + oData + "')\">Delete</a>";
        elLiner.innerHTML = links;
    };
    
	 var myColumnDefs = [
	                     {key:"id", label:"Id", sortable:true},
	                     {key:"firstname", label:"firstname", sortable:true},
	                     {key:"lastname", label:"lastname", sortable:true},
	                     {key:"email", label:"email", sortable:true},
	                     {key:"phone", label:"phone", sortable:false},
	                     {key:"mobile", label:"mobile", sortable:false},
	                     {key:"dob", label:"dob", formatter:"date", sortable:true},
	                     {key:"id", label:"Edit/Delete", formatter: YAHOO.widget.DataTable.formatEditLink}
	                 ];
	 var searchName = document.getElementById("searchName").value;
		
    var myDataSource = new YAHOO.util.DataSource("phonebook?searchName="+searchName);
    myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSON;
    //myDataSource.connXhrMode = "queueRequests";
    myDataSource.responseSchema = {
        resultsList: "data",
        fields: ["id","firstname","lastname","email","phone","mobile","dob"]
        
    };

    var myDataTable = new YAHOO.widget.DataTable("contactList", myColumnDefs, myDataSource);

    /*var mySuccessHandler = function() {
        this.set("sortedBy", null);
        this.onDataReturnAppendRows.apply(this,arguments);
    };
    var myFailureHandler = function() {
        this.showTableMessage(YAHOO.widget.DataTable.MSG_ERROR, YAHOO.widget.DataTable.CLASS_ERROR);
        this.onDataReturnAppendRows.apply(this,arguments);
    };
    var callbackObj = {
        success : mySuccessHandler,
        failure : myFailureHandler,
        scope : myDataTable
    };
    
    myDataSource.sendRequest("query=",callbackObj);
            
    return {
        oDS: myDataSource,
        oDT: myDataTable
    };*/
    
};

YAHOO.util.Event.addListener("contactSearchBtn", "click", YAHOO.com.sivalabs.phonebook.loadContacts); 
YAHOO.util.Event.addListener("addNewContactBtn", "click", YAHOO.com.sivalabs.phonebook.addNewContact);
YAHOO.util.Event.addListener(window, "load", YAHOO.com.sivalabs.phonebook.loadContacts);
