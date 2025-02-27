package com.trs.trs_booking_service.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Embeddable
public class TrainInfo {
    String trainName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Coach coachType;
    String sourceStation;
    String destinationStation;

    LocalTime sourceTime;
    LocalTime destinationTime;
    Integer journeyDurationInMins;
    Integer distanceInKms;

    public enum Coach{
        SL, AC
    }
}
