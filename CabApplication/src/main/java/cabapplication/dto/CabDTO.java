package cabapplication.dto;

import org.springframework.stereotype.Component;

@Component
public class CabDTO {
	
	private String carType;
	private float perKmRate;

	private int cabId;

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

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	@Override
	public String toString() {
		return "CabDTO [carType=" + carType + ", perKmRate=" + perKmRate + ", cabId=" + cabId + "]";
	}

	

}
