<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>Login Page</title>
	
	<style>
		.failed {
			color: red;
		}
	</style>
	
</head>

<body>

<h3>Welcome to Flight Search Engine</h3>
<h4>Login:</h4>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">

	
		<c:if test="${param.error != null}">
		
			<i class="failed">Invalid username or password. Try again.</i>
			
		</c:if>

		<c:if test="${param.logout != null}">

			<i>You have been logged out.</i>

		</c:if>
			
		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>

</body>

</html>












