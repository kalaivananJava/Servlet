<%@ page import="jakarta.servlet.ServletContext" %>
<%
    ServletContext context = application;
    String busName =(String) context.getAttribute("busName");
    String companyName = (String) context.getAttribute("companyName");
    String yearFounded = (String) context.getAttribute("yearFounded");
    String motto = (String) context.getAttribute("motto");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rajam</title>
</head>
<body>
    <h1><%=busName%></h1>
    <p>CompanyName::<%=companyName%></p>
    <p>Year::<%=yearFounded%></p>
    <p>Motto::<%=motto%></p>
    <p><a href="index.jsp">For Bookings</a></p>
</body>
</html>