package cabapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Driver extends AbstractUser {

	public Driver() {
		super();

	}

	public Driver(String username, String password, String mobileNumber, String email, String address) {
		super(username, password, mobileNumber, email, address);
	}

	public List<TripBooking> getTrips() {
		return trips;
	}

	public void setTrips(List<TripBooking> trips) {
		this.trips = trips;
	}

	@Id
	@GeneratedValue
	private int driverId;
	@NotNull
	private String licenceNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Cab cab;
	private double rating;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
    private List<TripBooking> trips;
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

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
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
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", cab=" + cab + ", rating=" + rating
				+ "]";
	}

}