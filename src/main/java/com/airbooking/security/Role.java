package com.airbooking.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.airbooking.security.Authority.*;

public enum Role {
    USER(Sets.newHashSet(AIRPLANE_READ, FLIGHT_READ)),
    ADMIN(Sets.newHashSet(AIRPLANE_READ, FLIGHT_READ, AIRPLANE_WRITE, FLIGHT_WRITE));

    private final Set<Authority> authorities;

    Role(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toSet());
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return simpleGrantedAuthorities;
    }
}
