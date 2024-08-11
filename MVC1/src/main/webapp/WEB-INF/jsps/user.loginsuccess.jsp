<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>
</head>
<body>
    <h1>Login Successful</h1>
    <p>Welcome, <%=request.getSession().getAttribute("username")%>
    
    <br><br><br><a href="home.jsp">Dont click here</a>
    
</body>
</html>
