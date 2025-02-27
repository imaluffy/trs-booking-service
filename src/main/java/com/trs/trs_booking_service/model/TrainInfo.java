package com.trs.trs_booking_service.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Embeddable
public class TrainInfo {
    String trainName;
    String coachType;
    String berthAllocated;
    String sourceStation;
    String destinationStation;

    LocalTime sourceTime;
    LocalTime destinationTime;
    Integer journeyDurationInMins;
    Integer distanceInKms;
}
