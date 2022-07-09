package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.TripBooking;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;

@SpringBootTest
class TripServiceImplTest {
	@Autowired
	TripServiceImpl tripService;
	
	@MockBean
	ITripRepository tripRepo;

	TripBookingDTO tripDto1 = null;
	TripBookingDTO tripDto2 = null;

	@BeforeEach
	public void testBeforeEach() {
		tripDto1 = new TripBookingDTO();
		tripDto1.setTripBookingId(1);
		tripDto1.setBill(100);
		tripDto1.setCustomerId(1);
		tripDto1.setDistanceInKm(90);
		tripDto1.setFromLocation("banaglore");
		tripDto1.setStatus(true);
		tripDto1.setToLocation("goa");
		tripDto1.setFromDateTime(LocalDateTime.now());
		tripDto1.setToDateTime(LocalDateTime.of(2022, 02, 01, 05, 04));

		tripDto2 = new TripBookingDTO();
		tripDto2.setTripBookingId(2);
		tripDto2.setBill(90);
		tripDto2.setCustomerId(2);
		tripDto2.setDistanceInKm(80);
		tripDto2.setFromLocation("mymbai");
		tripDto2.setStatus(true);
		tripDto2.setToLocation("goa");
		tripDto2.setFromDateTime(LocalDateTime.of(2022, 03, 01, 05, 04));
		tripDto2.setToDateTime(LocalDateTime.of(2022, 05, 01, 05, 04));
	}

	@Test
	void testGetAll() throws TripNotFoundException {
		List<TripBookingDTO> tripBooking = new ArrayList<>();
		tripBooking.add(tripDto1);
		tripBooking.add(tripDto2);
		List<TripBooking> list = Converter.convertTripToEntity(tripBooking);
		Mockito.when(tripRepo.findAll()).thenReturn(list);
		assertNotNull(tripService.getAll());
	}

	@Test
	void testGetById() throws TripNotFoundException {
		TripBooking trips = Converter.convertTripToEntity(tripDto1);
		Optional<TripBooking> optional = Optional.of(trips);
		Mockito.when(tripRepo.findById(1)).thenReturn(optional);
		assertThat(tripRepo.existsById(trips.getCustomerId())).isFalse();

	}

	@Test
	void testSave() throws TripNotFoundException {
		TripBooking trips = Converter.convertTripToEntity(tripDto1);
		Mockito.when(tripRepo.save(trips)).thenReturn(trips);
		assertThat(tripService.save(tripDto1)).isEqualTo(tripDto1);

	}

	@Test
	void testUpdate() throws Throwable {
		TripBooking tripBooking = Converter.convertTripToEntity(tripDto1);
		Optional<TripBooking> optional = Optional.of(tripBooking);
		Mockito.when(tripRepo.findById(1)).thenReturn(optional);
		Mockito.when(tripRepo.save(tripBooking)).thenReturn(tripBooking);
		tripDto1.setBill(90);
		tripDto1.setCustomerId(3);
		tripDto1.setDistanceInKm(100);
		tripDto1.setFromLocation("hyderbad");
		tripDto1.setStatus(true);
		tripDto1.setToLocation("goa");
		tripDto1.setFromDateTime(LocalDateTime.now());
		tripDto1.setToDateTime(LocalDateTime.of(2022, 02, 01, 05, 04));
		assertThat(tripService.save(tripDto1)).isEqualTo(tripDto1);
	}

	@Test
	void testDelete() {
		TripBooking tripBooking = Converter.convertTripToEntity(tripDto1);
		Optional<TripBooking> optional = Optional.of(tripBooking);

		Mockito.when(tripRepo.findById(1)).thenReturn(optional);
		Mockito.when(tripRepo.existsById(tripBooking.getTripBookingId())).thenReturn(false);
		assertFalse(tripRepo.existsById(tripBooking.getTripBookingId()));
	}

	@Test
	void testGetByCustomerId() throws CustomerNotFoundException {

		List<TripBookingDTO> tripBooking = new ArrayList<>();
		tripBooking.add(tripDto1);
		tripBooking.add(tripDto2);
		List<TripBookingDTO> trips = new ArrayList<>();
		trips.add(tripDto1);
		List<TripBooking> list = Converter.convertTripToEntity(trips);
		Mockito.when(tripRepo.getByCustomerId(1)).thenReturn(list);
		equals(tripService.getByCustomerId(1));
	}

	@Test
	void testCalculateBill() throws CustomerNotFoundException {
		double bill = tripDto1.getDistanceInKm() * 30.0;
		TripBooking tripBooking = Converter.convertTripToEntity(tripDto1);
		Mockito.when(tripRepo.findByCustomerId(1)).thenReturn(tripBooking);
		assertThat(tripService.calculateBill(1)).isEqualTo(bill);
	}

}
