package cabapplication.dto;

import org.springframework.stereotype.Component;

@Component
public class CabDTO extends AbstractUserDTO {

	public CabDTO() {
		super();

	}

	public CabDTO(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);

	}

	private int cabId;
	private String carType;
	private float perKmRate;

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

}
