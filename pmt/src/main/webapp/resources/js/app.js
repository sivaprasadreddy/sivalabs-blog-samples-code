Ext.onReady(function(){
	
	//Ext.Msg.alert("Hello World","All set!!!");

	Ext.create("Ext.form.Label", {
		text: "Hello World",
		renderTo: Ext.getBody()
		});
	
	Ext.create("Ext.Button",{
		text : "Hello World",
		handler : function(){
		Ext.Msg.alert("You clicked the hello world button");
		},
		renderTo : Ext.getBody()
		});
	
	Ext.create("Ext.Panel",{
		title : "Hello World Panel",
		items : [
		Ext.create("Ext.form.field.Text",{
		id:"nametext",
		fieldLabel : "Name"
		}),
		Ext.create("Ext.Button",{
		text : "Click",
		handler : function(){
			var book = Ext.create("com.sivalabs.extjs.Book","PrimeFaces",5000);
			console.log(book.title);
			console.log(book.price);
			
			Ext.Msg.alert("Hmmmm","You know how to click..Good!"+Ext.getCmp("nametext").getValue());
		}
		})
		],
		renderTo : Ext.getBody()
		});
	
	Ext.create("Ext.form.Panel",
			{
			renderTo : Ext.getBody(),
			width: 500,
			
			title : "Controls",
			url: "#",
			items : [
				{
				xtype : "radiogroup",
				fieldLabel : "Title",
				vertical:true,columns:1,
				items : [
				{boxLabel:"Mr",name:"title"},
				{boxLabel:"Ms",name:"title"}
				]
				},
				{
				xtype : "textfield",
				fieldLabel : "Name",
				allowBlank : false,
				maxLength : 50,
				msgTarget : "side"
				},
				{
				xtype : "datefield",
				fieldLabel : "Date of birth",
				msgTarget : "side"
				},
				{
				xtype : "textfield",
				fieldLabel : "Blog",
				vtype : "url"
				},
				{
				xtype : "numberfield",
				fieldLabel : "Years of experience",
				minValue : 5,
				maxValue : 15
				},
				{
				xtype : "textarea",
				fieldLabel : "Address",
				validator : function(val){
					if(val.indexOf("#") != -1 || val.indexOf(".") != -1)
					{
						return "Invalid characters like # or . in address";
					}
					return true;
				}
				},
				{
				xtype : "button",
				text : "Submit",
				listeners : {
					"click" : function(src){
					//src.up("form").submit();
						src.up("form").submit({
							success : function(form,action){
							alert("Successfully submitted");
							},
							failure : function(form,action){
							console.log(action.failureType);
							console.log(action.result);
							alert(action.response.status + ", " + action.response.statusText);
							}
						});
					
					}
				}
				}
			 ]
			});
	
});

Ext.define("com.sivalabs.extjs.Book",{
	title: "",
	price: 0,
	constructor: function(title, price){
		this.title = title;
		this.price = price;
	}
});