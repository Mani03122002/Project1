<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form action="balanceServlet" method="post">
<label for="accountNo">Account Number:</label>
<input name="accountNo" id="accountNo" type="number"/>

<button type="submit">Submit</button>
</form>

<%
String message=request.getParameter("message");
if (message != null && !message.isEmpty()) { %>
    <p style="color: green;"><%= message %></p>
<% } %>

<button class = "Go back" onclick = "window.location.href = 'customerdashboard.jsp'"> Go Back</button>

</body>
</html>