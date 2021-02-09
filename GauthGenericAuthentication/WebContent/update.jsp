<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="formValidation1.js"></script>
</head>
<%
if(session.getAttribute("userid")!=null)
{
	try
	{
	String userid=(String)session.getAttribute("userid");
	Class.forName("com.ibm.db2.jcc.DB2Driver");
	Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/abc1","Niharika1","auckland");
	PreparedStatement ps=con.prepareStatement("select * from register where emailid=?");
	ps.setString(1,userid);
	ResultSet rs=ps.executeQuery();
%>	
<body onload="document.UpdateServlet.fname.focus()">
<form action="UpdateServlet" method="post" name="UpdateServlet" onsubmit="return formValidation1()">

<center>
<table>
<%
while(rs.next())
{
 %>
<tr>
<td>First name</td>
<td><input type="text" name="fname" value="<%=rs.getString(1) %>"></td>
</tr><tr>
<td>Last name</td>
<td><input type="text" name="lname" value="<%=rs.getString(2) %>"></td>
</tr><tr>
<td>contact</td>
<td><input type="text" name="contact" value="<%=rs.getString(3) %>"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address" value="<%=rs.getString(4) %>"></td>
</tr>
<tr>
<td>State</td>
<td><select name="state">
<option value="Default">select a state</option>
<option value="<%=rs.getString(6) %>" disabled="disabled"><%=rs.getString(6) %></option>
<optgroup label="INDIA">
<option value="Delhi">Delhi</option>
<option value="Telangana State">Telangana State</option>
<option value="Maharastra">Maharastra</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="WestBengal">WestBengal</option>
</optgroup>
<optgroup label="USA">
<option value="America">America</option>
<option value="Mexico">Mexico</option>
<option value="Australia">Australia</option>
<option value="New zeland">New zeland</option>
</optgroup>
</select>
</td>
</tr>
<tr>
<td>City</td>
<td><select name="city">
<option value="Default">select a city</option>
<option value="<%=rs.getString(7) %>" disabled="disabled"><%=rs.getString(7) %></option>
<optgroup label="INDIA">
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Telangana State">Telangana State</option>
<option value="Maharastra">Maharastra</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="WestBengal">WestBengal</option>
</optgroup>
<optgroup label="USA">
<option value="America">America</option>
<option value="Mexico">Mexico</option>
<option value="Australia">Australia</option>
<option value="New zeland">New zeland</option>
</optgroup>
</select></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" value="<%=rs.getString(9) %>"></td>
</tr>

<tr>
<td>Security Question:</td>
<td>
<select name="ques">
<option value="Default">select a Question</option>
<option value="<%=rs.getString(11) %>" disabled="disabled"><%=rs.getString(11) %></option>
<option value="What is your petname">what is your pet name?</option>
<option value="What is your best friend name?">what is your best friend name?</option>
<option value="What is your favourite place?">What is your favourite place?</option>
</select>
</td>
</tr>
<tr>
<td>Security Answer</td>
<td><input type="text" name="ans" value="<%=rs.getString(12) %>"></td>
</tr>
<tr>
<td>Emailid:</td>
<td><input type="hidden" name="userid" value="<%=rs.getString(8)%>"></td>
</tr>
<tr>
	<td><input type="submit" value="UPDATE"></td>
	<td><input type="reset" value="REFRESH"></td>
	</tr>

</table>
</center>
</form>
<%}
}
catch(Exception e)
{
e.printStackTrace();
}
}
else
{
getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
}
%>
</body>
</html>