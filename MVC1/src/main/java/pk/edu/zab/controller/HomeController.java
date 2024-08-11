package pk.edu.zab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String afile="file1.xlsx";
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//generateHtml(out);
		//generateExcel(out,request);
		//makeDisapear(out,request);
		request.getRequestDispatcher("WEB-INF/jsps/home.jsp").forward(request, response);
		
		
	}



	private void makeDisapear(PrintWriter out,HttpServletRequest request) {
		
		
	}



	private void generateExcel(PrintWriter outt,HttpServletRequest request) {
		//add excel generation code 
//		
//		outt.println("<html><head><title>Progress of Servlet</title></head><body>");
//		//max='100000' will reflect the number of rows you are generating in excel
//		outt.println("<progress id='progress' max='100000'></progress>");
//		for(int i=0;i<100000;i++) {// this simulates the loop in which you are generating excel rows
//			// this will update in the excel outmost loop
//		outt.println("<script>document.getElementById('progress').value=\"" + i + "\"</script>");
//		outt.println("<script>document.getElementById('progress').style.display='none';</script>");
//		//outt.println("<a href='/"+afile+"'>Download File</a>");
//		outt.println("</body></html>");
//		outt.flush();		
//		}
	   
		
	}



	

	

}
