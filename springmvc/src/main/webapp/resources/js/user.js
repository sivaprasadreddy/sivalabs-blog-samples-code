function go(url)
{
	window.location = url;
}

function newUser()
{
	window.location = "saveUser";
}

function deleteUser(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}
