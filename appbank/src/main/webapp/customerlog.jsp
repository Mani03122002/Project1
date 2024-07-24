<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Login Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .container {
            display: flex;
            height: 100vh;
        }
        .left-side {
            background-color: #776E9A; /* Dark Lavender */
            color: black;
            font-family: 'Times New Roman', Times, serif;
            font-size: 24px;
            font-weight: bold;
            display: flex;
            justify-content: center;
            align-items: center;
            flex: 1;
        }
        .right-side {
            background-color: #D4C7ED; /* Light Lavender */
            display: flex;
            justify-content: center;
            align-items: center;
            flex: 1;
        }
        .login-form {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .login-form h2 {
            margin-bottom: 20px;
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        .login-form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="left-side">
            <div>CUSTOMER LOGIN</div>
        </div>
        <div class="right-side">
            <div class="login-form">
                <h2>Login</h2>
                <form action="customerloginServlet" method="post">
                    <label for="username"> Username</label>
                    <input type="text" id="username" name="username" required>
                    
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                    
                    <input type="submit" value="Login">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
