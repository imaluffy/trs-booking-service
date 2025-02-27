package com.trs.trs_booking_service.controller;

import com.trs.trs_booking_service.model.Ticket;
import com.trs.trs_booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking/ticket")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/add")
    ResponseEntity<?> addBooking(@RequestBody Ticket ticket){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addBooking(ticket));
    }

    @PostMapping("/cancel/{pnrValue}")
    ResponseEntity<?> cancelAllBooking(@PathVariable Long pnrValue){
        Integer response = bookingService.cancelAllBooking(pnrValue);
        if(response==1){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket cancelled successfully");
        }else if(response==-1){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket already cancelled");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket not available");
    }

    @PostMapping("/cancel/{pnrValue}/{pidValue}")
    ResponseEntity<?> cancelSingleBooking(@PathVariable Long pnrValue,@PathVariable Long pidValue){
        Integer response = bookingService.cancelSingleBooking(pnrValue,pidValue);
        if(response==1){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket cancelled successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket not available");
    }
}
