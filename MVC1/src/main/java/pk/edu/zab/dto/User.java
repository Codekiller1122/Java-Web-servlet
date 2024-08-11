package pk.edu.zab.dto;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String phoneno;
	
	public User() {}
	
	
	
	public User(String username, String password, String email, String phoneno) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}


	public User(int id, String username, String password, String email, String phoneno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneno=" + phoneno + "]";
	}
	
	
	
	
	
	
	

}
