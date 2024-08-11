package pk.edu.zab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pk.edu.zab.dao.UserDAO;
import pk.edu.zab.dto.User;

public class UserController extends HttpServlet {
    private String view;
    private String kase;
    private String controller;
    private String username;
    private String password;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("UserController invoked");
        System.out.println("View: " + request.getAttribute("view"));

        kase = (String) request.getAttribute("kase");

        if (kase.equals("auth")) {
            username = request.getParameter("username");
            password = request.getParameter("password");
            
          
            
            UserDAO userDAO = new UserDAO(getServletContext());

            userDAO.checkLogin(username, password);
            
            if(userDAO.checkLogin(username, password)) {
            	HttpSession session = request.getSession();
    			session.setAttribute("username",username);
            	response.sendRedirect("loginsuccess");
            }
            
            else {
            	response.sendRedirect("login");
            }
            
            
            
            
        } else if (kase.equals("login")) {
        	
        	
            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);

        } else if (kase.equals("logout")) {

            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);

        } else if (kase.equals("profile")) {

            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);

        } else if (kase.equals("register")) {

            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);
            
            
        } else if (kase.equals("loginsuccess")) {

            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);
            
            
        } else if (kase.equals("FirstUser")) {

            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);
            
            
        } else if (kase.equals("ShowAllUsers")) {

            view = (String) request.getAttribute("view");
            request.getRequestDispatcher(view).forward(request, response);
            

        } else if (kase.equals("register-success")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String phoneno = request.getParameter("phoneno");
                
                System.out.println(username);
                System.out.println(password);
                System.out.println(email);
                System.out.println(phoneno);

                
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setPhoneno(phoneno);

                    UserDAO userDAO = new UserDAO(getServletContext());

                    userDAO.addUser(user);

                    response.sendRedirect("login");
        }


         else if (kase.equals("changepassword")) {

        } else if (kase.equalsIgnoreCase("signup")) {

        } else if (kase.equals("verify")) {

        } else if (kase.equals("forgetpassword")) {

        } else if (kase.equals("reset-pass")) {

        } else if (kase.equals("complete-reset-pass")) {

        } else {
            System.out.println("None of the UserController cases are fired");
        }
    }
}
