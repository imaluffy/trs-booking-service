package com.trs.trs_booking_service.repo;

import com.trs.trs_booking_service.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Ticket, Long> {
    Long pnr(Long pnr);
}
