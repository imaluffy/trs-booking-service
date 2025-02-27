package com.trs.trs_booking_service.service;

import com.trs.trs_booking_service.model.Ticket;
import com.trs.trs_booking_service.repo.BookingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    public Ticket addBooking(Ticket ticket) {
        return bookingRepo.save(ticket);
    }

    @Transactional
    public Integer cancelAllBooking(Long pnrValue) {
        Optional<Ticket> ticketEntity= bookingRepo.findById(pnrValue);
        if(ticketEntity.isPresent()){

            if(!ticketEntity.get().getPnrActive())
                return -1;

            ticketEntity.ifPresent(ticket -> {
                        ticket.setBookingStatus(Ticket.BookingStatus.CANCELLED);
                        ticket.setPnrActive(false);

                        ticket.getPassengerList().forEach(passenger -> passenger.setActive(false));
                    }
            );
            return 1;
        }
        return 0;
    }

    @Transactional
    public Integer cancelSingleBooking(Long pnrValue, Long pidValue){
           Optional<Ticket> ticketEntity= bookingRepo.findById(pnrValue);
           if(ticketEntity.isPresent()){

               ticketEntity.ifPresent(ticket -> {
                           ticket.setBookingStatus(Ticket.BookingStatus.PARTIAL);
                           ticket.setPnrActive(false);

                   ticket.getPassengerList().forEach(passenger -> {
                       if(passenger.getPid().equals(pidValue))
                           passenger.setActive(false);
                   });
               });

               return 1;
           }
           return 0;
    }


}
