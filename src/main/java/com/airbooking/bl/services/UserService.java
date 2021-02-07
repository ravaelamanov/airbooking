package com.airbooking.bl.services;

import com.airbooking.da.entities.User;
import com.airbooking.da.repositories.UserRepository;


import com.airbooking.bl.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<UserDto, User, Long> {


    protected UserService(@Autowired UserRepository repository) {
        super(repository);
    }
}
