<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        label {
            display: block;
            margin: 10px 0 5px;
            color: #333;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
        .message {
            color: green;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Customer Details</h2>
        <form action="updatedetailServlet" method="post">
            <input type="hidden" id="accountNumber" name="accountNumber" value="<%= request.getAttribute("accountNumber") %>" required>
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%= request.getAttribute("name") %>">
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="<%= request.getAttribute("address") %>">
            
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" value="<%= request.getAttribute("mobileNumber") %>">
            
            <label for="emailId">Email ID:</label>
            <input type="email" id="emailId" name="emailId" value="<%= request.getAttribute("emailId") %>">
            
            <label for="accountType">Account Type:</label>
            <select id="accountType" name="accountType">
                <option value="Saving" <%= "savings".equals(request.getAttribute("accountType")) ? "selected" : "" %>>Saving</option>
                <option value="Current" <%= "current".equals(request.getAttribute("accountType")) ? "selected" : "" %>>Current</option>
            </select>
            
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" value="<%= request.getAttribute("dob") %>">
            
            <label for="idProof">ID Proof:</label>
            <input type="text" id="idProof" name="idProof" value="<%= request.getAttribute("idProof") %>">
            
            <button type="submit">Update Details</button>
        </form>
        
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null && !message.isEmpty()) { %>
            <p class="message"><%= message %></p>
        <% } %>
    </div>
</body>
</html>
