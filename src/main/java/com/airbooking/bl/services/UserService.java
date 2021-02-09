package com.airbooking.bl.services;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;


import com.airbooking.bl.dto.UserDto;
import com.airbooking.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<UserDto, User, Long> {
    protected UserService(@Autowired UserRepository repository) {
        super(repository);
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = modelMapper.toEntity(userDto);
        user.setRole(Role.USER);
        return modelMapper.toDto(repository.save(user));
    }
}
