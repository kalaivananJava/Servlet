<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="jakarta.servlet.ServletContext" %>
<%
    ServletContext context = application;
    String busName=(String)context.getAttribute("busName");
    String companyName = (String) context.getAttribute("companyName");
    String yearFounded = (String) context.getAttribute("yearFounded");
    String motto = (String) context.getAttribute("motto");
%>
        <html>

        <body>

            <h2>Hello Servlet</h2>


            ${Details}

            <div align="center">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>det of Details</h2>
                    </caption>
                    <tr>
                        <th>Available Date</th>
                        <th>Bus No</th>
                        <th>BusName</th>
                        <th>Available Seats</th>
                        <th>customer_name</th>
                    </tr>
                    <c:forEach var="det" items="${Details}">
                        <tr>
                            <td>
                                <c:out value="${det.availdate}" />
                            </td>
                            <td>
                                <c:out value="${det.busNo}" />
                            </td>
                            <td>
                                <c:out value="${det.busName}" />
                            </td>
                            <td>
                                <c:out value="${det.availableSeats}" />
                            </td>
                            <td>
                                <c:out value="${det.custome_name}" />
                            </td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </div>

   <ul>
    <c:forEach  var="det" items="${Details}">
        <li>
            <c:out value="${det}" /></li>
        
       
    </c:forEach>
     <h2>Bus Tickets booking</h2>
     <h1 items="${error}"></h1>
    <form action="/fruits" method="post">
    Available Date:: <input type="date" name="availdate" >
    Bus number:: <input type="number" name="busnumber" >
    Bus Name:: <input type="text" name="busName">
    Available Seats:: <input type="number" name="AvailSeats" value="5">
    CustomerName:: <input type="text" name="customerName" >
     <br>
     <input type="submit" value="Submit">
    </form>
   </ul>


${
    Details
}



<h1><%=busName%></h1>
<p>CompanyName::<%=companyName%></p>
<p>Year::<%=yearFounded%></p>
<p>Motto::<%=motto%></p>

        </body>

        </html>