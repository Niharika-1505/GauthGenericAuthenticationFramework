<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
<%
if(session.getAttribute("userid")!=null)
{
 %>
<body>
<h3 align="right"><a href="update.jsp">Update Profile</a></h3>
<h3 align="right"><a href="logout.jsp">Logout</a></h3>
Hello ${userid}
 <%
 }
 else
 {
 String message="LoginFirst";
 request.setAttribute("msg", message);
 getServletContext().getRequestDispatcher("/index.jsp").include(request,response);
 }
  %>
 <h2><center>Application under process</center></h2>
</body>
</html>