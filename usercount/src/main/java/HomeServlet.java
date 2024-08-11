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
    Integer count = (Integer) context.getAttribute("loggedInUserCount");
    if (count == null) {
      count = 0;
    }

    request.setAttribute("loggedInUserCount", count); // Set the count as a request attribute

    // Forward the request to home.jsp
    request.getRequestDispatcher("home.jsp").forward(request, response);
  }
}
