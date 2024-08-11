import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            response.setContentType("text/html");
            response.getWriter().println("<h1>Welcome, " + username + "!</h1>");
            response.getWriter().println("<p>This is your dashboard.</p>");
            response.getWriter().println("<a href='logout'>Logout</a>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
