<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
  <h1>Login</h1>
  <form action="LoginServlet" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>
    <img src="CaptchaServlet" alt="Captcha Image"><br>
    <label for="captcha">Enter the Captcha:</label>
    <input type="text" id="captcha" name="captcha" required><br>
    <input type="submit" value="Login">
  </form>
</body>
</html>
