package com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public enum Roles {
    USER,
    ADMIN;

    public List<SimpleGrantedAuthority> getAuthorities(){
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}