import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Initialization code, if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false); // Get the session without creating a new one

        // Check if the user is logged in (session exists and contains the username attribute)
        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

        // If the user is not logged in, redirect to the login page
        if (!isLoggedIn && !httpRequest.getRequestURI().endsWith("login.jsp")) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        chain.doFilter(request, response); // Continue the filter chain
    }

    public void destroy() {
        // Cleanup code, if needed
    }
}
