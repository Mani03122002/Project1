<%@ page language="java" import="java.sql.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit</title>
</head>
<body>

<%String message = request.getParameter("message"); %>
    <h2>Deposit Money</h2>
    <form action="depositServlet" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber" required><br><br>
        
        <label for="amount">Deposit Amount:</label>
        <input type="number" id="amount" name="amount" required><br><br>
        
        <button type="submit">Deposit</button>
    </form>
    
    <%if(message != null && !message.isEmpty()){ %>
    <p style="color:green;"><%=message %></p>
    <%} %>
</body>
</html>
