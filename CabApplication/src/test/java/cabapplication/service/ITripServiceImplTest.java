package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.entity.Cab;
import cabapplication.entity.Customer;
import cabapplication.entity.Driver;
import cabapplication.entity.TripBooking;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.ITripRepository;

@SpringBootTest
class ITripServiceImplTest {

	@Autowired
	ITripServiceImpl iTripServiceImpl;
	
	@MockBean
	ITripRepository triprepo;

	@Test
	void testgetAll() throws TripNotFoundException {
		TripBooking trip1= new TripBooking();
		trip1.setTripBookingId(1);
		trip1.setCustomerId(1);
		trip1.setFromLocation("Delhi");
		trip1.setToLocation("Goa");
		trip1.getFromDateTime();
		trip1.getToDateTime();
		trip1.isStatus();
		trip1.getDistanceInKm();
		trip1.getBill();
		
		TripBooking trip2= new TripBooking();
		trip2.setTripBookingId(2);
		trip2.setCustomerId(2);
		trip2.setFromLocation("Bnagalore");
		trip2.setToLocation("hyderabad");
		trip2.getFromDateTime();
		trip2.getToDateTime();
		trip2.isStatus();
		trip2.getDistanceInKm();
		trip2.getBill();
		
		List<TripBooking> tripBookingList = new ArrayList<>();
		tripBookingList.add(trip1);
		tripBookingList.add(trip2);
		
		Mockito.when(triprepo.findAll()).thenReturn(tripBookingList);	
	//	assertThat(iTripServiceImpl.getAll()).isEqualTo(tripBookingList);
	}

	@Test
	void testSave() {
		LocalDateTime fromdate=LocalDateTime.of(2022,02,01,05,04);
		LocalDateTime todate=LocalDateTime.of(2022,02,05,01,02);
		Cab cab= new Cab();
		Driver driver = new Driver();
		Customer customer = new Customer();
		TripBooking tb =new TripBooking();
		Mockito.when(triprepo.save(tb)).thenReturn(tb);	
		//assertThat(iTripServiceImpl.save()).isEqualTo(tb);
		
	}
	
	@Test
	void testUpdate() {
			  LocalDateTime fromdate=LocalDateTime.of(2017,01,25,10,30); 
			  LocalDateTime todate=LocalDateTime.of(2017,01,25,12,30); 
			  Cab cab= new Cab();
			  Driver driver = new Driver();
			  Customer customer = new Customer();
			  TripBooking tripBooking= new TripBooking();
			  TripBooking newtripBooking= new TripBooking();
			  triprepo.save(tripBooking);
<<<<<<< HEAD
			//  given(triprepo.findById(101)).willReturn(Optional.of(newtripBooking));
=======
			  //(triprepo.findById(101)).willReturn(Optional.of(newtripBooking));
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
			  List<TripBooking> tripbookingList = triprepo.findAll();
			  for(int i=0; i<tripbookingList.size(); i++) {
				  if(tripbookingList.get(i).getTripBookingId() == newtripBooking.getTripBookingId()) {
					//  assertEquals(newtripBooking, tripbookingList.get(i));
				  }
			  }
	}
				 
	@Test
	void testDelete() {
			  LocalDateTime fromdate=LocalDateTime.of(2017,01,25,10,30); 
			  LocalDateTime todate=LocalDateTime.of(2017,01,25,12,30); 
			  Cab cab= new Cab();
			  Driver driver = new Driver();
			  Customer customer = new Customer();
			  TripBooking tripBooking= new TripBooking();
			  tripBooking.setTripBookingId(101);
			  Mockito.when(triprepo.findById(tripBooking.getTripBookingId())).thenReturn(Optional.of(tripBooking));
<<<<<<< HEAD
			//  tripBooking.delete(tripBooking.getTripBookingId());
=======
			  //tripBooking.delete(tripBooking.getTripBookingId());
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
			  verify(triprepo).deleteById(tripBooking.getTripBookingId());
	}


	@Test
	void testgetByCustomerId() {
			  LocalDateTime fromdate=LocalDateTime.of(2017,01,25,10,30); 
			  LocalDateTime todate=LocalDateTime.of(2017,01,25,12,30); 
			  Cab cab= new Cab();
			  Driver driver = new Driver();
			  Customer customer = new Customer();
			  TripBooking tripBooking= new TripBooking();
			  List<TripBooking> tripBookingList= new ArrayList<TripBooking>();
			  tripBookingList.add(tripBooking);
			  Mockito.when(triprepo.findAll()).thenReturn(tripBookingList);
<<<<<<< HEAD
			 // tripBooking.getByCustomerId((tripBookingList.get(0).getTripBookingId());
=======
			  tripBooking.setCustomerId((tripBookingList.get(0).getTripBookingId()));
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
			  verify(triprepo).findAll();
				
		}

	@Test
	void testcalculateBill() {
		LocalDateTime fromdate=LocalDateTime.of(2017,01,25,10,30);
		LocalDateTime todate=LocalDateTime.of(2017,01,25,12,30);
		Cab cab= new Cab();
		Driver driver = new Driver();
		Customer customer = new Customer();
		TripBooking tripBooking= new TripBooking();
		List<TripBooking> tripBookingList= new ArrayList<TripBooking>();
		tripBookingList.add(tripBooking);
		Mockito.when(triprepo.findAll()).thenReturn(tripBookingList);
<<<<<<< HEAD
	//	tripBooking.calculateBill(tripBookingList.get(0).getCustomer().getCustomerId());
=======
		//tripBooking.calculateBill(tripBookingList.get(0).getCustomer().getCustomerId());
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
		verify(triprepo).findAll();
	}
}

