package pk.com.wstech.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pk.com.wstech.dao.BookDAO;
import pk.com.wstech.dto.Book;


public class BookServlet extends HttpServlet {
	
	//Servlet Definition: Class's object which can be invoked with a URL
	// init
	// ready to receive requests-- Service
	// destroy

    private static String INSERT_OR_EDIT = "/book.jsp";
    private static String LIST_BOOK = "/listBook.jsp";
    private BookDAO dao;// has a relationship with DAO

	@Override
	public void init() throws ServletException {
		super.init();
		 dao = new BookDAO(getServletContext());
		 //getServletContext().getRequestDispatcher(path)
	}





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	        String action = request.getParameter("action");
	       // HttpSession session = request.getSession(false);
	        //session.isNew();
	        
	        if (action.equalsIgnoreCase("delete")){
	            int bookId = Integer.parseInt(request.getParameter("bookId"));
	            dao.deleteBook(bookId);
	            
	            forward = LIST_BOOK;     
	            request.setAttribute("books", dao.getAllBooks());
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int bookId = Integer.parseInt(request.getParameter("bookId"));
	            Book book = dao.getBookById(bookId);
	            request.setAttribute("book", book);
	        } else if (action.equalsIgnoreCase("listBook")){
	            forward = LIST_BOOK;
	            request.setAttribute("books", dao.getAllBooks());
	        } else {
	            forward = INSERT_OR_EDIT;
	        }
	        
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Book book = new Book();
		 book.setTitle(request.getParameter("title"));
	     book.setAuthor(request.getParameter("author"));
	     book.setPrice(Double.parseDouble(request.getParameter("price")));
	     book.setCategoryId(Integer.parseInt(request.getParameter("categoryid")));
	     //dao.addBook(book);
	     String bookId = request.getParameter("bookId");
	     if(bookId == null || bookId.isEmpty())
	        {
	    	 dao.addBook(book);
	        }
	        else
	        {
	            book.setBookId(Integer.parseInt(bookId));
	            dao.updateBook(book);
	        }
	     	RequestDispatcher view = request.getRequestDispatcher(LIST_BOOK);
	        request.setAttribute("books", dao.getAllBooks());
	        view.forward(request, response);
	}

}
