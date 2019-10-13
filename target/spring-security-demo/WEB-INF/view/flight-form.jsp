<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<h2>Add a new flight</h2>
</head>
<body>
    <form:form action="saveFlight" modelAttribute="flight" method="post">
    <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Origin city:</label></td>
                <td><form:input path="originCity"/></td>
            </tr>
            <tr>
                <td><label>Destination city:</label></td>
                <td><form:input path="destinationCity"/></td>
            </tr>
            <tr>
                <td><label>Departure date (yyyy-MM-dd):</label></td>
                <td><form:input type="date" path="departureDate"/></td>
            </tr>
            <tr>
                <td><label>Price (in Euro):</label></td>
                <td><form:input type="number" path="price"/></td>
            </tr>
            <br>
            <p>DETAILS</p>
            <tr>
                <td><label>Flight number:</label></td>
                <td><form:input path="flightDetails.flightNumber"/></td>
            </tr>
            <tr>
                <td><label>Departure time(HH:mm:ss):</label></td>
                <td>
                    <form:input type="time" step="1" path="flightDetails.departureTime"/></td>
            </tr>
            <tr>
                <td><label>Quantity available:</label></td>
                <td><form:input type="number" path="flightDetails.quantityLeft"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>

    </form:form>

    <table>
</table>

    <p>
        <a href="${pageContext.request.contextPath}/admin/menu">Back to menu</a>
    </p>

</body>
</html>

