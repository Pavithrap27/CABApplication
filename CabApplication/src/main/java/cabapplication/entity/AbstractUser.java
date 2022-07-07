package cabapplication.entity;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractUser {
    @NotNull
	private String username;
	private String password;
	@Min(10)
	private String mobileNumber;
	@NotNull
	@Email
	private String email;
	private String address;

	protected AbstractUser(String username, String password, String mobileNumber, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}

	protected AbstractUser() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractUser [username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", address=" + address + "]";
	}

}
