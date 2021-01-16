package com.airbooking.bl.services;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;
import com.airbooking.ui.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Iterable<UserDto> findAll() {
        return toDto(userRepository.findAll());
    }

    public UserDto findById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElse(null);
        return toDto(user);
    }

    public UserDto createUser(UserDto userDto) {
        User user = toEntity(userDto);
        userRepository.save(user);
        return toDto(user);
    }

    private User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private Iterable<User> toEntity(Iterable<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            users.add(toEntity(userDto));
        }
        return users;
    }

    private Iterable<UserDto> toDto(Iterable<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }
}
