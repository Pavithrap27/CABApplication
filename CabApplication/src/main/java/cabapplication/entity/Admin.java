package cabapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin extends AbstractUser {
	public Admin() {

	}

	public Admin(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);

	}

	@Id
	@GeneratedValue
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
