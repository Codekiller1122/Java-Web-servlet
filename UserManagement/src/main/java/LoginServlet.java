import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserManagementSample userManagement = new UserManagementSample();

        if (userManagement.authenticateUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("HomeServlet");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
