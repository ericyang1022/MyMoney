package com.mymoney.model;

public class User {

	private Long id;
	
	private String username;
	private String password;
	
	private String firstName; //NB Think I would like to replace fn and ln with Name...
	private String lastName;
	
	/**
	 * Future Fields...
	 * Type?
	 * email address
	 */
	
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
	private void setId(Long id) {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
