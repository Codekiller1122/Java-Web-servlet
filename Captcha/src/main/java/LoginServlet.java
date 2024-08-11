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
        String enteredCaptcha = request.getParameter("captcha");

        // Verify username and password
        boolean loginSuccessful = verifyLogin(username, password);

        // Verify captcha
        boolean captchaValidated = verifyCaptcha(enteredCaptcha, request);

        if (loginSuccessful && captchaValidated) {
            // Store username in session attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to success page
            response.sendRedirect("success.jsp");
        } else {
            // Redirect back to login page
            response.sendRedirect("login.jsp");
        }
    }

    private boolean verifyLogin(String username, String password) {
        // Perform login verification logic here
        // Return true if login is successful, otherwise false
        // You can customize this method based on your authentication mechanism
        return username.equals("admin") && password.equals("admin");
    }

    private boolean verifyCaptcha(String enteredCaptcha, HttpServletRequest request) {
        // Perform captcha validation logic here
        // Return true if captcha is validated, otherwise false
        // You can customize this method based on your captcha implementation
        return enteredCaptcha.equalsIgnoreCase((String) request.getSession().getAttribute("captcha"));
    }
}
