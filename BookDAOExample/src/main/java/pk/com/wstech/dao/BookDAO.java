package pk.com.wstech.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import pk.com.wstech.dto.Book;
import pk.com.wstech.util.DbUtil;

//Purpose: DAO
// It shields all the Queries inside different methods
// Reusablity of methods

// Each DAO class corresponds to a table in database
// it will have all the queries needed to perform CRUD operations on this table

// Spring Data JPA--- DAO Auto generate
// Spring Data JPA ---- Named Query

// Runtime Byte Code generation
public class BookDAO {
	private Connection connection;
	
	public BookDAO(ServletContext ctx){
		connection = DbUtil.getConnection(ctx);
		System.out.println(connection);
	}
	
	 public void addBook(Book book) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into books(title,author,price,category_id) values (?, ?, ?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, book.getTitle());
	            preparedStatement.setString(2, book.getAuthor());
	            preparedStatement.setDouble(3, book.getPrice());
	            preparedStatement.setInt(4, book.getCategoryId());         
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	 
	 public void deleteBook(int bookId) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from Books where book_id=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, bookId);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void updateBook(Book book) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update users set title=?, author=?, price=?, category_id=?" +
	                            "where book_id=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, book.getTitle());
	            preparedStatement.setString(2, book.getAuthor());
	            preparedStatement.setDouble(3, book.getPrice());
	            preparedStatement.setInt(4, book.getCategoryId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public List<Book> getAllBooks() {
	        List<Book> books = new ArrayList<Book>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from Books");
	            while (rs.next()) {
	                Book book = new Book();
	                book.setBookId(rs.getInt("book_id"));
	                book.setTitle(rs.getString("title"));
	                book.setAuthor(rs.getString("author"));
	                book.setPrice(rs.getDouble("price"));
	                book.setCategoryId(rs.getInt("category_id"));
	                books.add(book);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	// close resultset
	        	// close statememt
	        	// close connection in the case of connection pooliing 
	        }

	        return books;
	    }
	    public Book getBookById(int bookId) {
	        Book book = new Book();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from books where book_id=?");
	            preparedStatement.setInt(1, bookId);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                book.setBookId(rs.getInt("book_id"));
	                book.setTitle(rs.getString("title"));
	                book.setAuthor(rs.getString("author"));
	                book.setPrice(rs.getDouble("price"));
	                book.setCategoryId(rs.getInt("category_id"));
	            
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return book;
	    }
}
