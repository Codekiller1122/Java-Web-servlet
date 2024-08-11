<%@ page import="java.util.List" %>
<%@ page import="pk.edu.zab.dao.UserDAO" %>
<%@ page import="pk.edu.zab.dto.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>All Users</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>All Users:</h1>
        <% 
            // Create a UserDAO object with a valid database connection
            UserDAO userDAO = new UserDAO(getServletContext());

            // Get all users from the database
            List<User> userList = userDAO.getAllUsers();
        %>
        <% if (!userList.isEmpty()) { %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (User user : userList) { %>
                        <tr>
                            <td><%= user.getUsername() %></td>
                            <td><%= user.getPassword() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getPhoneno() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p>No users found.</p>
        <% } %>
    </div>

    <!-- Add Bootstrap JS (optional, if you need Bootstrap's JavaScript features) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
