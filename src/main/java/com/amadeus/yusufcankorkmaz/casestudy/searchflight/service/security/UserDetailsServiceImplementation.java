package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.security;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user.User;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.ExceptionEntity;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.NotFoundException;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository.UserRepository;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.security.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByMail(username).orElseThrow(() -> new NotFoundException(ExceptionEntity.User));
        return new JwtUser(
                user.getId(),
                user.getMail(),
                user.getPassword(),
                user.getRole().getAuthorities()
        );
    }

}