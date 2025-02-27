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
    private String trainName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Coach coachType;
    private String sourceStation;
    private String destinationStation;
    private LocalTime sourceTime;
    private LocalTime destinationTime;
    private Integer journeyDurationInMins;
    private Integer distanceInKms;

    public enum Coach{
        SL, AC
    }
}
