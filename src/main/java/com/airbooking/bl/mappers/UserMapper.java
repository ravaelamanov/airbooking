package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.UserDto;
import com.airbooking.da.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<UserDto, User>{
    @Override
    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
