package com.airbooking.bl.services;

import com.airbooking.da.entities.User;
import com.airbooking.ui.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<T> implements IService<T>  {
    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public Iterable<T> findAll() {
        return toDto(userRepository.findAll());
    }

    @Override
    public T findById(long id) {
        return null;
    }

    @Override
    public T createUser(T userDto) {
        return null;
    }

    @Override
    public T updateUser(T userDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    protected abstract <U> T toDto(U entity);
    protected abstract <U> U toEntity(T dto);

    protected <U> Iterable<U> toEntity(Iterable<T> dtos) {
        List<U> users = new ArrayList<>();
        for (T dto : dtos) {
            users.add(toEntity(dto));
        }
        return users;
    }

    protected <U> Iterable<T> toDto(Iterable<U> entities) {
        List<T> dtos = new ArrayList<>();
        for (U entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}
