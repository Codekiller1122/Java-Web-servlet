

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userParam="billa";
	String passParam="gora";
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Post");
		String name = request.getParameter("username");
		String pass=request.getParameter("password");
		RequestDispatcher dispatch;
		
		if(name.equals(userParam)&&pass.equals(passParam)) {
			HttpSession session = request.getSession();
			session.setAttribute("userName",request.getParameter("username") );
			dispatch= request.getRequestDispatcher("home.jsp");		
		}else {
			dispatch= request.getRequestDispatcher("failure.jsp");
		}
		dispatch.forward(request, response);
		
	}

}
