package com.airbooking.bl.services;

import com.airbooking.da.entities.User;
import com.airbooking.ui.dto.UserDto;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    T findById(long id);

    T createUser(T userDto);

    T updateUser(T userDto);

    void deleteById(Long id);
}
