package com.trs.trs_booking_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    private Long pnr;
    private Long userId;
    private Long paymentId;
    private Integer trainId;
    private LocalDate bookingDate;
    private Boolean pnrActive;
    private Double totalFare;
    private TrainInfo trainInfo;
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "pnr")
    private List<Passenger> passengerList;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus bookingStatus;
    public enum BookingStatus{
        CANCELLED, BOOKED, PARTIAL
    }
}
