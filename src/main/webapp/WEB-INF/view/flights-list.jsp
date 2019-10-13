<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of available flights</title>
</head>
<body>
<h2>List of all flights</h2>
<form:form action="searchFlight" method="GET">
    <h2>Search flight:</h2>
    <p> Origin City: <input type="text" name="searchOriginCity" /></p>
    <p>Destination City: <input type="text" name="searchDestinationCity" /></p>
    <p><input type="submit" value="Search" class="add-button" /></p>
</form:form>
<table>

    <tr>
        <th>Origin City</th>
        <th>Destination City</th>
        <th>Departure Date</th>
        <th>Price</th>
        <th>Details</th>
        <th>Buy</th>
    </tr>

    <c:forEach var="tempFlight" items="${flights}">
        <c:url var="showDetails" value="/user/showDetails">
            <c:param name="flightId" value="${tempFlight.id}" />
        </c:url>

        <c:url var="orderFlight" value="/user/orderFlight">
            <c:param name="flightId" value="${tempFlight.id}" />
        </c:url>
        <tr>
            <td>${tempFlight.originCity}</td>
            <td>${tempFlight.destinationCity}</td>
            <td><fmt:formatDate value="${tempFlight.departureDate}" pattern="yyyy-MM-dd" /></td>
            <td>${tempFlight.price}</td>
            <td><a href="${showDetails}">Show Flight Details</a></td>
            <td><a href="${orderFlight}">Buy a ticket</a></td>
        </tr>
    </c:forEach>

</table>
<p>
    <a href="${pageContext.request.contextPath}/user/menu">Back to menu</a>
</p>
</body>
</html>
