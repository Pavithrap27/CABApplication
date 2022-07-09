package cabapplication.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDTO extends AbstractUserDTO {

	public CustomerDTO() {
		super();

	}

	public CustomerDTO(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);

	}

	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + "]";
	}

}
