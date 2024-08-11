package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cake;

@WebServlet("/CakeServlet")
public class CakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArrayList<Cake> cakelist = new ArrayList<>();
 
    public CakeServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name =request.getParameter("CakeName");
		System.out.println(Name);
		Cake aCake=checkCake(Name);
		System.out.println(aCake);
		PrintWriter out=response.getWriter();
		if(aCake!=null){
			out.println("<h1>"+aCake+"</h1>");
			out.print("<a href=\"index.html\">Back to home</a>");
		}
		
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String Name = request.getParameter("Cakename");
	String Price = request.getParameter("Cakeprice");
	
	PrintWriter out = response.getWriter();
	Cake c = new Cake(Name,Price);
	cakelist.add(c);
	
	for(int i=0; i<cakelist.size();i++)
	{
		out.println("<h1>"+cakelist.get(i)+"</h1>" );
	}
	out.print("<a href=\"index.html\">Back to home</a>");
	}
	
	Cake checkCake(String name){	
		Cake cake1=null;
		System.out.println("list"+cakelist);
		for(int i=0;i<cakelist.size();i++){	
			Cake cake=cakelist.get(i);
			System.out.println(cake+"---");
			if(cake!=null && name.equals(cake.getName())){
				System.out.println("equal");
				cake1=cake;
			}else {
				System.out.println("not equal");
				cake1=new Cake("No such Cake Found","-1");
			}
		}
		return cake1;
	}
	
	int checkcake(String name){	
		
		for(int i=0;i<cakelist.size();i++)
		{	Cake cake1=cakelist.get(i);
			if(name.equals(cake1.getName()))
			{
				return i;
				
			}
		}
		return -1;
	}
}
