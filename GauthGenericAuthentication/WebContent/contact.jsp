<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script
type="text/javascript" language="javascript">    
javascript:window.history.forward(1);
</script>

<%  
response.setHeader("Pragma","no-cache");  
response.setHeader("Cache-Control","no-store");  
response.setHeader("Expires","0");  
response.setDateHeader("Expires",-1);  
%>
<script type="text/javascript" src="formValidation.js"></script>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>
<body onLoad="document.registration.fname.focus()">
<form action="RegisterServlet" method="post" name="registration" onsubmit="return formValidation()">
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#AD7934">
  <tr>
    <td width="230" valign="top"><table width="226" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td style="text-align:center;"><a href="index.jsp"><img src="images/index_02.gif" alt="" width="226" height="139" border="0" /></a></td>
  </tr>
  <tr>
    <td valign="top" style="padding-left:50px; padding-right:20px; padding-top:20px; padding-bottom:20px;">
	<div class="menu"><a href="index.jsp">Home Page</a></div>
	<div class="menu"><a href="index.jsp">Login</a></div>
	<div class="menu"><a href="content.jsp">Services</a></div>
	<div class="menu"><a href="content.jsp">Products</a></div>
	<div class="menu"><a href="content.jsp">Support</a></div>
	<div class="menu"><a href="content.jsp">Staff</a></div>
	<div class="menu"><a href="content.jsp">Links</a></div>
	<div class="menu"><a href="content.jsp">About Us</a></div>
	</td>
  </tr>
  <tr>
    <td style="padding-left:20px; padding-right:10px;">
	<div style="text-align:center;"><img src="images/index_47.gif" width="161" height="28" alt="" /></div>
	<div class="body1" style="padding-top:10px;"><span style="color:#663300;">15th Jan,06</span><br />
	  Lorem ipsum dolor sit amet, consectetuer adi quis turpis eu liepil.<br /><br />
	  <a href="content.jsp">read more</a> <img src="images/index_57.gif" width="9" height="5" alt="" /><br />
	</div>
	<div class="body1" style="padding-top:10px;"><span style="color:#663300;">15th Jan,06</span><br />
	  Lorem ipsum dolor sit amet, consectetuer adi quis turpis eu liepil.<br /><br />
	  <a href="content.jsp">read more</a> <img src="images/index_57.gif" width="9" height="5" alt="" /><br />
	</div>
	<div class="body1" style="padding-top:10px;"><span style="color:#663300;">15th Jan,06</span><br />
	  Lorem ipsum dolor sit amet, consectetuer adi quis turpis eu liepil.<br /><br />
	  <a href="content.jsp">read more</a> <img src="images/index_57.gif" width="9" height="5" alt="" /><br />
	</div>
	</td>
  </tr>
</table>
	</td>
    <td width="320" valign="top" bgcolor="#7F4F20">
		<div><img src="images/index_05.gif" width="320" height="333" alt="" /></div>
		<div style="font-size:14px; font-weight:bold; padding-left:15px; color:#F8F979;">Content Page</div>
		<div class="body1" style="padding-top:15px;"><form id="form2" name="form2" method="post" action="" style="margin:auto;">
          <table width="98%" border="0" align="center" cellpadding="2" cellspacing="4">
            <tr>
              <td width="64%" colspan="2"><span class="body">First Name</span><br>
                <input type="text" name="fname" style="width:68%; height:13px;" /></td></tr>
            <tr>
              <td colspan="2"><span class="body">Last Name:</span><br>
              <input type="text" name="lname" style="width:68%; height:13px;" /></td></tr>
            <tr>
              <td colspan="2"><span class="body">Contact:</span><br>
              <input type="text" name="contact" style="width:68%; height:13px;" /></td></tr>
            <tr>
              <td colspan="2"><span class="body">Address:</span><br>
              <textarea rows="10" cols="20" name="address"></textarea></td></tr>
            <tr>
              <td><span class="body">Gender</span>&nbsp;&nbsp;&nbsp;
              <span class="body"><input type="radio" name="gender" value="Male">Male&nbsp&nbsp
              <input type="radio" name="gender" value="Female" checked="checked">Female</span></td>
              </tr>
              <tr>
<td>State
<select name="state">
<option value="Default">select a state</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Telangana State">Telangana State</option>
<option value="Karnataka">Karnataka</option>
<option value="Tamilandu">Tamilandu</option>
<option value="Kerala">kerala</option>
</select>
</td>
</tr>
<tr>
<td>City&nbsp;&nbsp;
<select name="city">
<option value="Default">select a city</option>
<option value="Vijayawada">Vijayawada</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Bangalore">Bangalore</option>
<option value="Chennai">Chennai</option>
<option value="Trivendrum">Trivendrum</option>
</select></td>
</tr>
 <tr>
              <td colspan="2"><span class="body">Emailid:</span><br>
              <input type="text" name="userid" style="width:68%; height:13px;" /></td></tr>
            <tr>
             <td colspan="2"><span class="body">Password:</span><br>
              <input type="password" name="password" style="width:68%; height:13px;" /></td>
              </tr>
              <tr>
             <td colspan="2"><span class="body">Confirm Password:</span><br>
              <input type="password" name="password1" style="width:68%; height:13px;" /></td>
              </tr>
              <tr>
             <td colspan="2"><span class="body">Date of Birth</span><br>
              <input type="date" name="dob" min="1966-01-01" max="2015-01-01" style="width:68%; height:13px;" /></td>
              </tr>
              <tr>
<td>Security Question:<BR>
<select name="ques">
<option value="Default">select a Question</option>
<option value="What is your petname">what is your pet name?</option>
<option value="What is your best friend name?">what is your best friend name?</option>
<option value="What is your favourite place?">What is your favourite place?</option>
</select>
</td>
</tr>
     <tr>
             <td colspan="2"><span class="body">Security Answer</span><br>
              <input type="text" name="ans" style="width:68%; height:13px;" /></td>
     </tr> 
    
	<tr>
<td><strong><h3> captcha</h3></strong></td>
<td><img src="http://localhost:8086/BankWebsiteApplicationNew/CaptchaServlet"></td>
</tr>
<tr>
<td><strong><h3>captcha answer</h3></strong></td>
<td><input type="text" name="code"></td>
</tr>
 <tr>
	<td><input type="submit" value="REGISTER">
	<input type="reset" value="REFRESH"></td>
	</tr>
	<tr>
	<td><h4>${msg}</h4></td></tr>
 </table>
 </form></div>
		</td>
    <td width="230" valign="top">
		<div style="padding-top:20px; padding-right:12px; padding-bottom:50px; text-align:right;">
			<table width="128" border="0" cellspacing="3" cellpadding="0">
			  <tr>
				<td align="center" valign="top"><img src="images/index_08.gif" width="33" height="21" alt="" /></td>
				<td align="center" valign="top"><img src="images/index_10.gif" width="36" height="21" alt="" /></td>
				<td align="center" valign="top"><img src="images/index_12.gif" width="33" height="21" alt="" /></td>
				<td align="center" valign="top"><img src="images/index_14.gif" width="26" height="21" alt="" /></td>
			  </tr>
			</table>
		</div>
				<div style="text-align:center; padding-top:12px; padding-bottom:12px;"><a href="#"><img src="images/index_38.gif" alt="" width="198" height="107" border="0" /></a></div>
		<div style="padding-left:15px; padding-right:15px; text-align:center;"><img src="images/index_43.gif" width="191" height="23" alt="" /></div>
		<div class="body1" style="padding-left:22px; padding-right:22px; padding-top:6px;">Lorem ipsum dolor sit amet, consect etuer adipiscing elit. <br />
		  <br />
	    Nullam quis turpis eulibero varius esti bulum. <br />
	    <br />
	    In feugiated etturpis acrisus liquet rhoncus. Nam cursus molestie metus.<br />
		<br />
		<a href="content.jsp">read more</a> <img src="images/index_57.gif" width="9" height="5" alt="" /></div>
		<div style="text-align:center; padding-top:20px; padding-bottom:12px;"><a href="#"><img src="images/index_38.gif" alt="" width="198" height="107" border="0" /></a></div>
	</td>
  </tr>
  <tr>
    <td class="footer"><a href="index.jsp">Home Page</a>  :  <a href="content.jsp">About Us</a>  :  <a href="content.jsp">Services</a>  <a href="content.jsp">Products</a></td>
    <td bgcolor="#7F4F20" class="footer" style="color:#C38D46;"></td>
    <td class="footer"><a href="content.jsp">Support</a> : <a href="content.jsp">Staff</a> : <a href="content.jsp"></a><a href="content.jsp">Linkes<a href="content.jsp"></a> :<br /> 
    <a href="content.jsp"></a><a href="contact.jsp">Contacts</a></td>
  </tr>
</table>
</form>
</body>
</html>