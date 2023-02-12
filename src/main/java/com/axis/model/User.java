package com.axis.model;

public class User {
	private String username;
	private String useremail;
	private String password;
	public User() {
	}
	public User(String username, String useremail, String password) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", useremail=" + useremail + ", password=" + password + "]";
	}

	
	

}
