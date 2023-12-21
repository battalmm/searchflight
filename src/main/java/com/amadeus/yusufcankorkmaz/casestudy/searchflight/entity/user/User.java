package com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user;


import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String password;
    private String mail;
    private Roles role;
}
