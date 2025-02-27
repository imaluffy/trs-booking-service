package com.trs.trs_booking_service.controller;

import com.trs.trs_booking_service.model.Ticket;
import com.trs.trs_booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/booking")
    ResponseEntity<?> addBooking(@RequestBody Ticket ticket){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addBooking(ticket));
    }
}
