<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Customers</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            padding: 20px;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        .delete-button {
            padding: 5px 10px;
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>All Customers</h2>
        <table>
            <thead>
                <tr>
                    <th>Account Number</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Mobile Number</th>
                    <th>Email ID</th>
                    <th>Account Type</th>
                    <th>Date of Birth</th>
                    <th>ID Proof</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Map<String, String>> customers = (List<Map<String, String>>) request.getAttribute("customers");
                    if (customers != null) {
                        for (Map<String, String> customer : customers) {
                %>
                <tr>
                    <td><%= customer.get("accountNumber") %></td>
                    <td><%= customer.get("name") %></td>
                    <td><%= customer.get("address") %></td>
                    <td><%= customer.get("mobileNumber") %></td>
                    <td><%= customer.get("emailId") %></td>
                    <td><%= customer.get("accountType") %></td>
                    <td><%= customer.get("dob") %></td>
                    <td><%= customer.get("idProof") %></td>
                    <td>
                        <form action="deletecustomerServlet" method="post">
                            <input type="hidden" name="accountNumber" value="<%= customer.get("accountNumber") %>">
                            <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
