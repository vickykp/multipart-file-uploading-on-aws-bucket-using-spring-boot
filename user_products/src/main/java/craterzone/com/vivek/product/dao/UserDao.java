package craterzone.com.vivek.product.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDao {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private String dob;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "mobile_cc")
	private String mobileCc;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "date_joined")
	private String dateJoined;
	
	@Column(name = "date_modified")
	private String dateModified;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "user")
	private String role;
	
	@Column(name = "file_name")
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

	public UserDao(Long id, String email, String firstName, String lastName, String dob, String mobileNo,
			String mobileCc, String password, String dateJoined, String dateModified, int type, boolean active,
			String role, String file) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.mobileCc = mobileCc;
		this.password = password;
		this.dateJoined = dateJoined;
		this.dateModified = dateModified;
		this.type = type;
		this.active = active;
		this.role = role;
		this.file = file;
	}

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDao [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", mobileNo=" + mobileNo + ", mobileCc=" + mobileCc + ", password=" + password
				+ ", dateJoined=" + dateJoined + ", dateModified=" + dateModified + ", type=" + type + ", active="
				+ active + ", role=" + role + ", file=" + file + "]";
	}
	
	
	
	
	

	

}
