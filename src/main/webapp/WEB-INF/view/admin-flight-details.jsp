<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Details</title>
</head>
<body>
<form:form action="showDetails" modelAttribute="flightDetails" method="get">
<form:form action="showDetails" modelAttribute="flight" method="get">
<form:hidden path="id"/>

    <table>
    <h2>Flight Details</h2>
    <tr>
        <th>Flight Number</th>
        <th>Departure Time</th>
        <th>Quantity Left</th>
        <th>Origin City</th>
        <th>Destination City</th>
        <th>Departure Date</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>${flightDetails.flightNumber}</td>
        <td><fmt:formatDate value="${flightDetails.departureTime}" pattern="HH:mm:ss" /></td>
        <td>${flightDetails.quantityLeft}</td>

        <td>${flight.originCity}</td>
        <td>${flight.destinationCity}</td>
        <td><fmt:formatDate value="${flight.departureDate}" pattern="yyyy-MM-dd" /></td>
        <td>${flight.price}</td>
    </tr>

</table>
</form:form>
</form:form>

<p>
    <a href="${pageContext.request.contextPath}/admin/list">Back to list</a>
</p>


</div>

</div>
</body>
</html>