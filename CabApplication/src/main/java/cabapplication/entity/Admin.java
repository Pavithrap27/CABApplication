package cabapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser {
	
	@Id
	@GeneratedValue
	private int adminId;
	public Admin() {
		super();
		this.adminId=adminId;
	}

	

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
