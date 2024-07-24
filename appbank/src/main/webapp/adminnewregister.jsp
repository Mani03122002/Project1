<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register New Account</title>
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
<%String message = request.getParameter("message"); %>
    <div class="container">
        <h2>Register New Account</h2>
        <form action="registerServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" required>
            
            <label for="emailId">Email ID:</label>
            <input type="email" id="emailId" name="emailId" required>
            
            <label for="accountType">Account Type:</label>
            <select id="accountType" name="accountType" required>
                <option value="Saving">Saving</option>
                <option value="Current">Current</option>
            </select>
            
            <label for="initialAmount">Initial Amount:</label>
            <input type="number" id="initialAmount" name="initialAmount" required>
            
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>
            
            <label for="idProof">ID Proof:</label>
            <input type="text" id="idProof" name="idProof" required>
            
            <button type="submit">Register</button>
        </form>
    </div>
     <%if(message != null && !message.isEmpty()){ %>
    <p style="color:green;"><%=message %></p>
    <%} %>
</body>
</html>
