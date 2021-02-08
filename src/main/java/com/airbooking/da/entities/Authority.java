package com.airbooking.da.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    private Long id;

    @NotNull
    private String authority;

    @ManyToMany
    private Set<User> username;

    public Set<User> getUsername() {
        return username;
    }

    public void setUsers(Set<User> username) {
        this.username = username;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
