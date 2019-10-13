<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>ADMIN Home Page</title>
</head>

<body>

<h2>ADMIN Home Page</h2>

<hr>
<p>
	User: <security:authentication property="principal.username" />
	<br><br>
	Role(s): <security:authentication property="principal.authorities" />
</p>
<h2>OPTIONS:</h2>
<p>
	<label>Show list of all available flights:</label>
	<a href="${pageContext.request.contextPath}/admin/list">The list</a>
</p>
<p>
	<label>Add a new flight to the database:</label>
	<a href="${pageContext.request.contextPath}/admin/add">Add</a>
</p>
<p>
	<label>Do you want to exit Flight Search Engine? </label>

	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">

	<input type="submit" value="Logout" />
</p>

</form:form>
</body>

</html>









