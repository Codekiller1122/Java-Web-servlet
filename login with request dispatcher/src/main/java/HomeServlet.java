import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        Integer loggedInUserCount = (Integer) context.getAttribute("loggedInUserCount");

        // Set the content type and character encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Write the HTML response
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Home</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Welcome!</h1>");
        response.getWriter().println("<p>Currently, there are " + loggedInUserCount + " user(s) logged in.</p>");
        response.getWriter().println("<a href='login.jsp'>Go back to Login</a>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
