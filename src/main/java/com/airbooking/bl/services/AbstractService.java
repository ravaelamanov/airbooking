package com.airbooking.bl.services;

import com.airbooking.bl.mappers.IMapper;
import com.airbooking.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.NoSuchElementException;

public abstract class AbstractService<Dto, Entity, ID> implements IService<Dto, ID> {

    @Autowired
    protected IMapper<Dto, Entity> modelMapper;

    protected CrudRepository<Entity, ID> repository;

    protected AbstractService(CrudRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Dto> findAll() {
        return modelMapper.toDto(repository.findAll());
    }

    @Override
    public Dto findById(ID id) {
        Entity entity;
        try {
            entity = repository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException("Entity not found. Entity id: " + id.toString());
        }
        return modelMapper.toDto(entity);
    }

    @Override
    public Dto create(Dto dto) {
        Entity entity = modelMapper.toEntity(dto);
        return modelMapper.toDto(repository.save(entity));
    }

    @Override
    public Dto update(Dto dto) {
        Entity entity = modelMapper.toEntity(dto);
        return modelMapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
