package com.airbooking.bl.services;

public interface IService<T, ID> {
    Iterable<T> findAll();

    T findById(ID id);

    T createUser(T userDto);

    T updateUser(T userDto);

    void deleteById(ID id);
}
