package com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail);
}
