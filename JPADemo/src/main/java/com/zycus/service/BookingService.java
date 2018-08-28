package com.zycus.service;

import java.sql.Date;

import com.zycus.bo.Booking;
import com.zycus.bo.Passenger;
import com.zycus.bo.Train;
import com.zycus.bo.User;
import com.zycus.dao.GenericDAO;

public class BookingService {
	GenericDAO dao = new GenericDAO();
	
	public void add(Object obj) {
		dao.add(obj);
	}
	
	public void doBooking(int userId, int trainId) {
		User user = dao.fetchById(User.class, userId);
		Booking booking = new Booking();
		booking.setBookingDate(new Date(System.currentTimeMillis()));
		booking.setUser(user);
		Train train = dao.fetchById(Train.class, trainId);
		booking.setTrain(train);		
	}
	
	public void addPassenger(int bookId) {
		Booking booking = dao.fetchById(Booking.class, bookId);
		Passenger passenger = new Passenger();
		passenger.setName("Rupali");
		passenger.setAge(21);
		passenger.setBooking(booking);
		dao.add(passenger);
	}
	
	
}
