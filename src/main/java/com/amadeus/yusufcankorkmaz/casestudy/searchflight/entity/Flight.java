package com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flight")
@Entity
public class Flight extends BaseEntity {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    @ManyToOne( fetch = FetchType.LAZY)
    private Airport departureAirport;
    @ManyToOne( fetch = FetchType.LAZY)
    private Airport arrivalAirport;

}
