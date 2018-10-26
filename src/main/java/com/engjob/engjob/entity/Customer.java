package com.engjob.engjob.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
	
	@Id
    private String id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Profile profile;
    
    public Customer() {}

	public Customer(String firstname, String lastname, String phone, String email, Profile profile) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", email=" + email + ", profile=" + profile + "]";
	}

    public String getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Profile getProfile() {
		return profile;
	}

}
