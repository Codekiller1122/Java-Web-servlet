import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class SessionFilter implements Filter {
    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        HttpSession session = httpRequest.getSession(false);

        if (session == null && !path.equals("/login.jsp") && !path.equals("/LoginServlet")) {
            // Redirect the user to the login page if session is null (not logged in)
            httpResponse.sendRedirect("login.jsp");
        } else {
            // Allow the request to be processed by other filters and servlets
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}
