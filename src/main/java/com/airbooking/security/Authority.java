package com.airbooking.security;

public enum Authority {
    FLIGHT_READ("flight:read"),
    FLIGHT_WRITE("flight:write"),
    AIRPLANE_READ("airplane:read"),
    AIRPLANE_WRITE("airplane:write");

    private final String authority;

    Authority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
