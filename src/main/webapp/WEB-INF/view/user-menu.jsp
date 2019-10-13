<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Flight Search Engine Home Page</h2>
	<hr>
	
	<p>
	Welcome to the Flight Search Engine home page!
	</p>
	<hr>

	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	<hr>
	<h2>OPTIONS:</h2>
	<p>
		<label>Show list of all available flights:</label>
		<a href="${pageContext.request.contextPath}/user/list">The list</a>
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









