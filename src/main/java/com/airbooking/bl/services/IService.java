package com.airbooking.bl.services;

public interface IService<Dto, ID> {
    Iterable<Dto> findAll();

    Dto findById(ID id);

    Dto create(Dto dto);

    Dto update(Dto dto);

    void deleteById(ID id);
}
