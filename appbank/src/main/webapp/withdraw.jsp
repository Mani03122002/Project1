<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdrawal</title>
</head>
<body>
    <h1>Withdrawal</h1>
    <%
        String message = request.getParameter("message");
        String balance = request.getParameter("balance");
        if (message != null) {
            out.println("<p>" + message + "</p>");
        }
        if (balance != null) {
            out.println("<p>Remaining Balance: " + balance + "</p>");
        }
    %>
    <form action="withdrawServlet" method="post">
        Account Number: <input type="text" name="accountNumber"><br>
        Amount: <input type="text" name="amount"><br>
        <input type="submit" value="Withdraw">
    </form>
</body>
</html>
