<%@ page import="classes.User, utilities.HelperUtility" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<% User user = (User) session.getAttribute("user"); %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/COMP3095_TEAM_DNS/css/main.css" />
	<title>Reports</title>
</head>
<body>
	<%= HelperUtility.popNav(user) %>
	<div class="container">
		<img class="uc_img" src="../img/underconstruction.png" height="40%" width="40%" alt="Under Construction" />
	</div>
</body>
</html>