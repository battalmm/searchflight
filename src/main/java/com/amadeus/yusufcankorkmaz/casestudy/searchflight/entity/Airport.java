package com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "airport")
@Entity
public class Airport extends BaseEntity{

    private String cityName;

}
