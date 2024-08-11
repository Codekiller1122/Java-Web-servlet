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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {
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
}
