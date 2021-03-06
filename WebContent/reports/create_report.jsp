<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/authentication.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="/COMP3095_TEAM_DNS/css/main.css" />
<title>Create Report</title>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date" />
	<jsp:include page="../includes/navigation.jsp" />
	<div class="container">
		<h1>Create Report Template</h1>
		<form action="CreateReport" method="POST">
			<fieldset>
				<legend class="left-label">1. Details: </legend>
				<label>Report Template: </label> <input type="text"
					name="templateName" /> <label>Date: </label> <input type="text"
					name="report-date" id="report-date"
					value='<fmt:formatDate value="${date}" pattern='dd/MM/yyyy'/>'
					disabled> <br /> <label>Department: </label> <select
					name="departmentId" id="ddlDepartment">
					<c:forEach items="${departments}" var="department">
						<option value="${department.departmentId}"><c:out
								value="${department.departmentName}" />
						</option>
					</c:forEach>
				</select>
				<hr />
				
				<legend class="left-label">	2.Section I: 
					<input type="text" name="sec1Title" />
				</legend>
				<fieldset>
					<label>Criteria 1:</label> 
					<input type="text" name="s1criteria" />
					<label>Maximum: </label> 
					<select name="s1eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5" selected>5</option>
					</select> 
					<br /> 
					<label>Criteria 2:</label> <input type="text" name="s1criteria" /> 
						<label>Maximum: </label> 
						<select	name="s1eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br /> 
					<label>Criteria 3:</label> 
					<input type="text" name="s1criteria" /> 
					<label>Maximum: </label> 
					<select	name="s1eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br /> 
					<label>Criteria 4:</label> 
					<input type="text"	name="s1criteria" /> 
					<label>Maximum: </label> 
					<select	name="s1eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br /> 
					<label>Criteria 5:</label> 
					<input type="text"	name="s1criteria" /> 
					<label>Maximum: </label> 
					<select	name="s1eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br />
				</fieldset>
				<hr />

				<legend class="left-label">
					3.Section II: <input type="text" name="sec2Title" />
				</legend>
				<fieldset>
					<label>Criteria 1:</label> 
					<input type="text" name="s2criteria" />
					<label>Maximum: </label> 
					<select name="s2eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5" selected>5</option>
					</select> 
					<br /> 
					<label>Criteria 2:</label> 
					<input type="text"	name="s2criteria" /> 
					<label>Maximum: </label> 
					<select	name="s2eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br /> 
					<label for=>Criteria 3:</label> 
					<input type="text" name="s2criteria" /> 
					<label>Maximum: </label> 
					<select	name="s2eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br />
				</fieldset>
				<hr />

				<legend>
					3.Section III: <input type="text" name="sec3Title" />
				</legend>
				<fieldset>
					<label>Criteria 1:</label> <input type="text" name="s3criteria" />
					<label>Maximum: </label> 
					<select name="s3eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5" selected>5</option>
					</select> 
					<br /> 
					<label>Criteria 2:</label> 
					<input type="text"	name="s3criteria" /> 
					<label>Maximum: </label> 
					<select name="s3eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br /> 
					<label for=>Criteria 3:</label> 
					<input type="text" name="s3criteria" /> 
					<label>Maximum: </label> 
					<select	name="s3eval">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select> 
					<br />
				</fieldset>
				<hr />
				<input type="submit" value="Create" />
				<input type="reset"	value="Cancel" />
			</fieldset>
		</form>
		<h3>${error}</h3>
	</div>
</body>
</html>