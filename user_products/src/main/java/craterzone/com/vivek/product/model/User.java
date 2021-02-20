package craterzone.com.vivek.product.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class User {
	
    private Long id;
	
	
	private String email;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private String dob;
	
	
	private String mobileNo;
	
	
	private String mobileCc;
	
	
	private String password;
	
	
	private String dateJoined;
	
	
	private String dateModified;
	
	
	private int type;
	
	
	private boolean active;
	
	
	private String role;
	
	
	private String file;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getMobileCc() {
		return mobileCc;
	}


	public void setMobileCc(String mobileCc) {
		this.mobileCc = mobileCc;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDateJoined() {
		return dateJoined;
	}


	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}


	public String getDateModified() {
		return dateModified;
	}


	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}



	
	
}
