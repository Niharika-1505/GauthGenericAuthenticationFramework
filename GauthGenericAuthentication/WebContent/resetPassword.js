function resetPassword()
{
	var uemail=document.resetpassword.userid;
	var upassword=document.resetpassword.password1;
	var upassword1=document.resetpassword.password2;
	if(email_validation(uemail))
	{
	if(password1_validation(upassword,7,12))
	{
		if(password2_validation(upassword1,7,12))
		{
			return true;										
		}											
	}
	}
	return false;
}
function email_validation(uemail)
{
var letter=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9])+\.([A-Za-z0-9]{2,4})+$/;	
if(uemail.value.match(letter))
{
return true;	
}
else
	{
	alert("Please enter the valid emailid");
	uemail.focus();
	return false;
	}
}
function password1_validation(upassword,mx,my)
{
var password_len=upassword.value.length;
if(password_len==0||password_len<mx||password_len>my)
	{
	alert("Password length must be between "+mx+" "+"to"+" "+my);
	upassword.focus();
	return false;
	}
else
	{
	return true;
	}

}
function password2_validation(upassword1,mx,my)
{
var password_len=upassword1.value.length;
if(password_len==0||password_len<mx||password_len>my)
	{
	alert("New Password length must be between "+mx+" "+"to"+" "+my);
	upassword1.focus();
	return false;
	}
else
	{
	return true;
	}

}