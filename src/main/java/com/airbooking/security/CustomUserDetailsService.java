package com.airbooking.security;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: " + username);
        }

        return user;

/*        boolean enabled = user.isEnabled();
        boolean accountNonExpired = user.isAccountNonExpired();
        boolean credentialsNonExpired = user.isCredentialsNonExpired();
        boolean accountNonLocked = user.isAccountNonLocked();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                user.getAuthorities());*/
    }

    @PostConstruct
    private void postConstruct() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEmail("admin@gmail.com");
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        User user = new User();
        user.setUsername("ravaelamanov");
        user.setPassword(passwordEncoder.encode("r159357r"));
        user.setEmail("ravaelamanov@gmail.com");
        user.setRole(Role.USER);
        userRepository.save(user);
    }

}
