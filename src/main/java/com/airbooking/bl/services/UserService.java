package com.airbooking.bl.services;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;
import com.airbooking.ui.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<UserDto, User, Long> {

    protected UserService(@Autowired UserRepository repository) {
        super(repository);
    }

    @Override
    protected User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    @Override
    protected UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
