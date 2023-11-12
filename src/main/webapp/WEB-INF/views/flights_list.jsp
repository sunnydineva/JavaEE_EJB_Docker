<%@ page import="com.airline.models.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="com.airline.models.Pilot" %>
<%--
  Created by IntelliJ IDEA.
  User: sunny
  Date: 9.11.23 г.
  Time: 9:25 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/jpaStyles.css"/>
    <title>Flight list</title>
</head>

<body>
    <h1>List of Flights</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
            <th>Price</th>
            <th>Airplane</th>
            <th>Seating</th>
            <th>Number of pilots</th>
            <th>Pilot names</th>
        </tr>

        <%
            List<Flight> flightList = (List<Flight>) request.getAttribute("flight_list");

            for (int i = 0; i < flightList.size(); i++)
            {

        %>
        <tr>
            <td><%= flightList.get(i).getId()%></td>
            <td><%= flightList.get(i).getFlightOrigin()%></td>
            <td><%= flightList.get(i).getFlightDestination()%></td>
            <td><%= flightList.get(i).getFlightTime()%></td>
            <td><%= flightList.get(i).getPrice()%></td>
            <td><%= flightList.get(i).getAirplaneDetails().getPlaneMake() + " " + flightList.get(i).getAirplaneDetails()
                    .getModelName()%></td>
            <td><%= flightList.get(i).getAirplaneDetails().getSeatingCapacity()%>

            <td>

                    <%

                            if(flightList.get(i).getPilots() != null) {


                        %>
                    <%= flightList.get(i).getPilots().size() %> pilots
                    <%
                        }
                        else {

                        %>

                No pilots yet

                    <%
                            }
                        %>

            <td>

                <%

                    if (flightList.get(i).getPilots() != null)
                    {

                        List<Pilot> pList = (List<Pilot>) flightList.get(i).getPilots();

                        for (Integer j = 0; j < pList.size(); j++)
                        {


                %>

                <%=
                (j + 1) + ") " + pList.get(j).getFirstName() + " " + pList.get(j).getLastName()
                        + " (" + pList.get(j).getPilotRank() + ")" + "<br />"
                %>

                <%
                        } //for

                    } //if

                %>

            </td>


        </tr>

        <tr>
            <td colspan="8">No passengers on this flight yet</td>
        </tr>

        <%
            }
        %>

    </table>

</body>

</html>
