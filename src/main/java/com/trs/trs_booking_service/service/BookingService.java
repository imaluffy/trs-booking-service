package com.trs.trs_booking_service.service;

import com.trs.trs_booking_service.model.Ticket;
import com.trs.trs_booking_service.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    public Ticket addBooking(Ticket ticket) {
        return bookingRepo.save(ticket);
    }
}
