<%@ page import="pk.edu.zab.dao.UserDAO" %>
<%@ page import="pk.edu.zab.dto.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>First User Details</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>First User Details:</h1>
        <% 
            // Create a UserDAO object with a valid database connection
            UserDAO userDAO = new UserDAO(getServletContext());

            // Get the first user from the database
            User firstUser = userDAO.getFirstUser();
        %>
        <% if (firstUser != null) { %>
            <div class="card">
                <div class="card-body">
                    <p class="card-text">Username: <%= firstUser.getUsername() %></p>
                    <p class="card-text">Password: <%= firstUser.getPassword() %></p>
                    <p class="card-text">Email: <%= firstUser.getEmail() %></p>
                    <p class="card-text">Phone Number: <%= firstUser.getPhoneno() %></p>
                </div>
            </div>
        <% } else { %>
            <p>No user found.</p>
        <% } %>
    </div>

    <!-- Add Bootstrap JS (optional, if you need Bootstrap's JavaScript features) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
