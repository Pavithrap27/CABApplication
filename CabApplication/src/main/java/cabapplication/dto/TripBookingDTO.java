package cabapplication.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import cabapplication.entity.Driver;

@Component
public class TripBookingDTO  {
	private int tripBookingId;
	private int customerId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private double distanceInKm;
	private double bill;
	
	public int getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public double getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
}
