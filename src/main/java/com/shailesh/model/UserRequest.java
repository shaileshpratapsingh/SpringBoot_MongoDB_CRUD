package com.shailesh.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Shailesh
 *
 */
public class UserRequest {

	@ApiModelProperty(notes = "First Name of the user", required = true)
	private String firstName;
	
	@ApiModelProperty("Sur Name of the user")
	private String surName;
	
	@ApiModelProperty(notes = "Title of the user", required = true)
	private String title;
	
	@ApiModelProperty(notes = "Date of birth of the user", required = true)
	private Date dob;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
