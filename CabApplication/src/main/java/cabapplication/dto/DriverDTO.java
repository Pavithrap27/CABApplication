package cabapplication.dto;

import org.springframework.stereotype.Component;

import cabapplication.entity.Cab;
@Component
public class DriverDTO extends AbstractUserDTO {
	
	public DriverDTO() {
		super();

	}

	public DriverDTO(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);

	}

	private int driverId;
	private String licenceNo;
	private CabDTO cab;
	private double rating;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}


	
	public CabDTO getCab() {

		return cab;
	}

	public void setCab(CabDTO cab) {
		this.cab = cab;
	}


	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "DriverDTO [driverId=" + driverId + ", licenceNo=" + licenceNo + ", cab=" + cab + ", rating=" + rating
				+ "]";
	}

	
}
