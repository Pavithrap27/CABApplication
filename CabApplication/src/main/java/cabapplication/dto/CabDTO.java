package cabapplication.dto;

import org.springframework.stereotype.Component;

@Component
public class CabDTO {
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

	@Override
	public String toString() {
		return "CabDTO [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}

}
