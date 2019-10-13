<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <title>Orders</title>
</head>
<body>
<h2>List of all your orders</h2>
<table>

    <tr>
        <th>Origin City</th>
        <th>Destination City</th>
        <th>Departure Date</th>
        <th>Price</th>
        <th>Details</th>
    </tr>
    <c:forEach var="tempFlight" items="${flights}">
        <c:url var="orders" value="/user/orders">
            <c:param name="flightId" value="${tempFlight.id}" />
        </c:url>


        <tr>
            <td>${tempFlight.originCity}</td>
            <td>${tempFlight.destinationCity}</td>
            <td><fmt:formatDate value="${tempFlight.departureDate}" pattern="yyyy-MM-dd" /></td>
            <td>${tempFlight.price}</td>
            <td><a href="${orders}">Show Flight Details</a></td>

        </tr>
    </c:forEach>


</table>

<p>
    <a href="${pageContext.request.contextPath}/user/menu">Back to menu</a>
</p>
</body>
</html>