<%@ page import="java.util.List" %>
<%@ page import="com.airline.controllers.Passengers" %>
<%@ page import="com.airline.models.Passenger" %><%--
  Created by IntelliJ IDEA.
  User: sunny
  Date: 11.11.23 г.
  Time: 21:38 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/jpaStyles.css"/>
    <title>Passengers list</title>
</head>
    <body>

    <h1>List of Passengers</h1>

    <table>
        <tr>
            <th>Id </th>
            <th>First name </th>
            <th>Last name </th>
            <th>Date of birth </th>
            <th>Gender </th>
        </tr>

        <%
            List<Passenger> pList = (List<Passenger>) request.getAttribute("passengers_list");
            for (int i = 0; i < pList.size(); i++)
            {
        %>

            <tr>

                <td> <%= pList.get(i).getId() %></td>
                <td> <%= pList.get(i).getFirstName() %></td>
                <td> <%= pList.get(i).getLastName() %></td>
                <td> <%= pList.get(i).getDob() %></td>
                <td> <%= pList.get(i).getGender() %></td>

            </tr>

            <tr>
                <td colspan="4">No flight tickets yet</td>
            </tr>

        <%
            }
        %>

    </table>

</body>
</html>
