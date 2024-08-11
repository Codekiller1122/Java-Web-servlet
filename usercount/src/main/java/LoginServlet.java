import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static User[] users = {
    new User("admin", "admin"),
    new User("user1", "password1"),
    new User("user2", "password2")
    // Add more users as needed
  };

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    User authenticatedUser = authenticateUser(username, password);
    if (authenticatedUser != null) {
      HttpSession session = request.getSession();
      session.setAttribute("username", username); // Store username in session attribute

      // Update the count of logged-in users
      ServletContext context = request.getServletContext();
      synchronized (context) {
        Integer count = (Integer) context.getAttribute("loggedInUserCount");
        if (count == null) {
          count = 1;
        } else {
          count++;
        }
        context.setAttribute("loggedInUserCount", count);
      }

      response.sendRedirect("HomeServlet");
    } else {
      response.sendRedirect("login.jsp");
    }
  }

  private User authenticateUser(String username, String password) {
    for (User user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return user;
      }
    }
    return null; // User authentication failed
  }

  // User class representing a user with username and password
  private static class User {
    private String username;
    private String password;

    public User(String username, String password) {
      this.username = username;
      this.password = password;
    }

    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
    }
  }
}
