function formValidation()
{
	
	var ufname=document.registration.fname;	
	var ulname=document.registration.lname;
	var ucontact=document.registration.contact;
	var uaddress=document.registration.address;
	var ustate=document.registration.state;
	var ucity=document.registration.city;
	var uemail=document.registration.userid;
	var upassword=document.registration.password;
	var upassword1=document.registration.password1;
	var uques=document.registration.ques;
	var uans=document.registration.ans;
	if(fname_validation(ufname))
		{
		if(lname_validation(ulname))
			{
			if(contact_validation(ucontact))
			{
				if(address_validation(uaddress))
					{
					if(state_validation(ustate))
						{
						if(city_validation(ucity))
							{
							if(email_validation(uemail))
								{
								if(password_validation(upassword,7,12))
								{
									if(password1_validation(upassword1,7,12))
									{
										if(ques_validation(uques))
										{
											if(ans_validation(uans))
												{
												return true;										
												}											
										}
										}
									}
									}
							}
							}
					}
				}
				}
		}
	return false;
	}

	function fname_validation(ufname)
	{
	var letter=/^[A-Za-z]+$/;
	if(ufname.value.match(letter))
		{
		return true;
	}
	else
		{
		alert("First Name Must be Alphabetic character only");
	ufname.focus();
	return false;

		}
	}
	function lname_validation(ulname)
	{
	var letter=/^[A-Za-z]+$/;
	if(ulname.value.match(letter))
		{
		return true;
	}
	else
		{
		alert("Last Name Must be Alphabetic character only");
	ulname.focus();
	return false;

		}
	}
function contact_validation(ucontact)
{
var contact_len=ucontact.value.length;
if(contact_len==10)
	{
	var number=/^[0-9]+$/;
	if(ucontact.value.match(number))
		{
		return true;
		}
	else
		{
		alert("Contact must be Numeric Only");
		ucontact.focus();
		return false;
		}
	
	}
else
	{
	alert("Contact must be 10 digit only");
	ucontact.focus();
	return false;
	}
}
function address_validation(uaddress)
{
var letter=/^[A-Za-z0-9_\-\.\,]+$/;	
if(uaddress.value.match(letter))
	{
	return true;
	}
else
	{
	alert("Please enter the valid address");
	uaddress.focus();
	return false;
	}
}
function state_validation(ustate)
{
if(ustate.value=="Default")
	{
	alert("Please Select the state from the list");
	ustate.focus();
	return false;
	}
else
	{
	return true;
	}
}
function city_validation(ucity)
{
if(ucity.value=="Default")
	{
	alert("Please Select the city from the list");
	ucity.focus();
	return false;
	}
else
	{
	return true;
	}
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
function password_validation(upassword,mx,my)
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
function password1_validation(upassword1,mx,my)
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
function ques_validation(uques)
{
if(uques.value=="Default")
	{
	alert("Please select the question from the list");
	uques.focus();
	return false;
	}
else
{
return true;	
}
}
function ans_validation(uans)
{
var letter=/^[A-Za-z0-9]+$/;
if(uans.value.match(letter))
	{
	return true;
	}
else
	{
	alert("Please enter the correct answer");
	uans.focus();
	return false;
	}
	}











	
	
	
	
	