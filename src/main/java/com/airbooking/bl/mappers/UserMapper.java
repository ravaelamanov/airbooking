package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.UserDto;
import com.airbooking.da.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserMapper extends AbstractMapper<UserDto, User>{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(UserDto.class, User.class)
                .addMappings(m -> m.skip(User::setPassword))
                .setPostConverter(dtoEntityConverter());
    }

    @Override
    protected void dtoEntityCustomMapping(UserDto userDto, User user) {
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    }
}
