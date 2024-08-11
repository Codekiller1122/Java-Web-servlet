package pk.edu.zab.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private RequestDispatcher dispatch;
	private String controller;
	//private UserController userController;
	private String view;
	private String kase;
	private int count=0;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Base Url: "+request.getRequestURI());
		System.out.println("********************"+request.getRequestURI()+"     "+count+++"********************");
		String url = resolveUrl(request.getRequestURI());
		
		System.out.println("Resolve URL^^^^^^^^^^^^^^^^^^^^^"+url+"^^^^^^^^^^^^^^^^^^^^^^^");
		
		if(url == null){
			view = "/WEB-INF/jsps/error.jsp?"+request.getRequestURI();// goto error page with typed url
			System.out.println("resolve URL returned null");
		}else if(url.equals("/")){// home page case
			System.out.println("homepage case");
			view = "/WEB-INF/jsps/home.jsp";
			//System.out.println(view);
		}else{ // here we need to send it to the corresponding servlet with the view information
			if(controller.equals("public")){
				view = "/WEB-INF/pub/"+url+".jsp";
			}else{
			view = "/WEB-INF/jsps/"+url+".jsp";
			}
			//System.out.println(view);	
		}
		
		// need to invoke the relative controller here
				if(controller.equals("home")){
					request.setAttribute("view",view);
					dispatch = request.getRequestDispatcher("/HomeController");
					dispatch.forward(request, response);
				}else if(controller.equals("user")){
					request.setAttribute("view",view);request.setAttribute("kase", kase);
					dispatch = request.getRequestDispatcher("/UserController");
					dispatch.forward(request, response);
				}else if(controller.equals("static")) {
					System.out.println("Its a static resource");
					//URL resource = getServletContext().getResource(request.getPathInfo());
				    //if(resource != null) { // static resource
				        RequestDispatcher rd = getServletContext().getNamedDispatcher("default");
				        rd.forward(request, response);
				        return;
				   // }
				}else{
					System.out.println("where to send don't know");
				}
		
		
	}
	
	public String resolveUrl(String uri0) {
	    System.out.println("inside resolveURL with url:" + uri0);

	    String view = null;
	    if (uri0 == null) {
	        System.out.println("Should not occur at all:resolveUrl");
	    } else if (uri0.equals("/")) {
	        view = "/";
	        controller = "home";
	    } else if (uri0.contains(".")) {
	        System.out.println("static resource");
	        controller = "static";
	    } else if (uri0.startsWith("/user/FirstUser/profile/")) {
	        controller = "user";
	        kase = "FirstUser.profile.1";
	        view = "user.FirstUser.profile.1";
	    } else if (uri0.split("/").length == 2) { // should make it strong here by checking the pages in the db
	        String parts[] = uri0.split("/");
	        controller = "public";
	        view = parts[parts.length - 1];
	        kase = view;
	        System.out.println("Inside resolve URL" + kase);
	    } else if (uri0.split("/").length == 3) {
	        System.out.println("time to invoke controller");
	        String parts[] = uri0.split("/");
	        // if statement required for parts.length > 2
	        controller = parts[parts.length - 2];
	        kase = parts[parts.length - 1];
	        System.out.println("kase from resolve URL:" + kase);
	        view = parts[parts.length - 2] + "." + parts[parts.length - 1];
	    } else {
	        System.out.println("%%%%%%%%%%%%%%%  not able to handle this url:" + uri0 + "%%%%%%%%%%%%%%%%%%%%");
	        String parts[] = uri0.split("/");
	        for (int i = 0; i < parts.length; i++) {
	            System.out.println("%%%%%%%%%%%%%%%%%" + parts[i] + "%%%%%%%%%%%%%%%%%%%");
	        }
	    }

	    return view;
	}



}

