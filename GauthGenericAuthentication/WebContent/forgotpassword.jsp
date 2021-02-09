<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<form action="ForgotServlet" method="post">
<center>
<table>
<tr>
<td>Emailid:</td>
<td><input type="text" name="emailid"></td>
</tr>
<tr>
<td>Security Question</td>
<td><select name="ques">
<option value="Default">select a Question</option>
<option value="What is your petname">what is your pet name?</option>
<option value="What is your best friend name?">what is your best friend name?</option>
<option value="What is your favourite place?">What is your favourite place?</option>
</select>
</td>
</tr>
<tr>
<td><strong><h3>Security Answer:</h3></strong>
</td>
<td><input type="text" name="ans">
</td>
</tr>
<tr>
<td>
<input type="submit" value="forgot password"></td>
</tr>
</table>
</center>
</form>
</body>
</html>








