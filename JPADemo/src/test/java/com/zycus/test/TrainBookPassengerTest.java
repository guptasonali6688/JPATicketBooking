package com.zycus.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.zycus.bo.Booking;
import com.zycus.bo.Passenger;
import com.zycus.bo.Train;
import com.zycus.bo.User;
import com.zycus.dao.GenericDAO;
import com.zycus.service.BookingService;

public class TrainBookPassengerTest {

	@Test
	public void testAddUser() {
		BookingService bs = new BookingService();
		User user = new User();
		user.setUsername("sonali");
		user.setEmail("gs@gmail.com");
		bs.add(user);
	}
	
	@Test
	public void testAddTrain() {
		BookingService bs = new BookingService();
		Train train = new Train();
		train.setName("EXPRESS 501");
		train.setSource("MUMBAI");
		train.setDestination("DELHI");
		bs.add(train);
	}
	
	@Test
	public void testAddBooking() {
		BookingService bs = new BookingService();
		bs.doBooking(1,1);
	}
	
	@Test
	public void testAddPassenger() {
		BookingService bs = new BookingService();
		bs.addPassenger(1);
		
	}

}
