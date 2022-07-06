package cabapplication.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminDTO extends AbstractUserDTO {

	public AdminDTO() {
		super();
	}

	public AdminDTO(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);
	}

	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
