<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        .container {
            max-width: 500px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        h1 {
            margin-top: 0;
        }

        .error-message {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Error</h1>
    <% String errorMessage = (String) request.getAttribute("error"); %>
    <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
        <p class="error-message"><%= errorMessage %></p>
    <% } else { %>
        <p>An error occurred.</p>
    <% } %>
    <p>Please try again later or contact the administrator for assistance.</p>
</div>
</body>
</html>
