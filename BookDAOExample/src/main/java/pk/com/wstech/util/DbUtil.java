package pk.com.wstech.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;


public class DbUtil {
	private static Connection connection = null;// 1 connection for the whole app
	
	public static Connection getConnection(ServletContext context) {
	      if (connection != null)
	            return connection;
	        else {
	        	 try {
	                
	                 String driver = context.getInitParameter("jdbc.driver");;
	                 String url = context.getInitParameter("jdbc.mysql://localhost:3306/userdao");
	                 String user = context.getInitParameter("jdbc.root");
	                 String password = context.getInitParameter("jdbc.admin");
	                 Class.forName(driver);
	                 connection = DriverManager.getConnection(url, user, password);
	             } catch (ClassNotFoundException e) {
	                 e.printStackTrace();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	             return connection;
	        }
	}
	
	

}
