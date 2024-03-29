<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open Redirect Vulnerability</title>
</head>
<body>
	<h2>Open Redirect Vulnerability</h2>

	The following field goes directly to a
	<code>response.sendRedirect("http://www.mysite.com");</code>
	call.
	
	<form action="" method="post">
		<label for="goto">Give me a url to go to!</label> 
		<input name="goto" size="50" /> <input type="submit" value="Go!">
	</form>

	<%
		if (request.getParameter("goto") != null) {
			//not validated or sanitized!
			response.sendRedirect(request.getParameter("goto")); 
		}
	%>

	<br><br><br>
	<form action="" method="post">
		<label for="gotosafe">Ok, this one is safer, I swear!</label> 
		<input name="gotosafe" size="50" /> <input type="submit" value="Go!">
	</form>
<%
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from emp where id="+eid);
if (rs != null) {
rs.next();
String name = rs.getString("name");
%>

Employee Name: <%= name %>

	<%
		if (request.getParameter("gotosafe") != null) {
			URI uri = new URI(request.getParameter("gotosafe"));
			uri = uri.normalize(); //just like in path traversal vulnerabilities
			if(!"localhost".equals(uri.getHost())){
				%>That URL wasn't at this host!!<%
			} else {
				response.sendRedirect(request.getParameter("gotosafe")); //validated!
			}
		}
	%>
</body>
</html>