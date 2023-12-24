package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.security;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.request.UserCreateRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.response.AuthenticationResponse;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.request.AuthenticationRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user.Roles;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user.User;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.ExceptionEntity;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.NotFoundException;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImplementation userDetailService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(JwtService jwtService,
                                 UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 UserDetailsServiceImplementation userDetailService,
                                 AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailService = userDetailService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );

        User user = userRepository.findByMail(authenticationRequest.getEmail()).orElseThrow(()-> new NotFoundException(ExceptionEntity.User));
        UserDetails userDetails = userDetailService.loadUserByUsername(user.getMail());
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse register(UserCreateRequest userCreateRequest) {

        User newUser = User.builder()
                .mail(userCreateRequest.getEmail())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .firstName(userCreateRequest.getName())
                .lastName(userCreateRequest.getSurname())
                .role(Roles.USER)
                .build();

        UserDetails user = userDetailService.loadUserByUsername(userRepository.save(newUser).getMail());
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}