package cabapplication.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tripbooking")
public class TripBooking {
	@Id
	@GeneratedValue
	private int tripBookingId;
	
	private int customerId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
    
	@OneToOne(cascade=CascadeType.ALL,mappedBy="customer")
	@JoinColumn(name="id")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Driver driver;
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public int getTripBookingId() {
		return tripBookingId;
	}
	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", driver=" + driver + ", fromLocation=" + fromLocation
				+ ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime
				+ ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill=" + bill + "]";
	}
	
	
}