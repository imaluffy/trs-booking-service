package com.trs.trs_booking_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long pid;
    private Long pnr;
    private Integer seatNo;
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer age;
    private Boolean active;

    public enum Gender{
        M, F
    }
}
