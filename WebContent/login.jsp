<%@page import="javax.websocket.Session"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/COMP3095_TEAM_DNS/css/main.css" />
<title>Login Page</title>
</head>
<body>
<div class="container">
	<h2>Login</h2>
	<br />
	<form action="Login" method="post">
		Username: 
		<input type="text" name="username" /><br />
		Password: 
		<input type="password" name="password"/><br />
		Remember Me: <input type="checkbox" name="remember" /><br />
		<input type="submit" />
	</form>
		<%if (session.getAttribute("error") !=null) { %>
			<p><%=session.getAttribute("error") %></p>
			<% } %>
			<% session.removeAttribute("error"); %>

</div>
</body>
</html>