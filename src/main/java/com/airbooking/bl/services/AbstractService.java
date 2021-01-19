package com.airbooking.bl.services;

import com.airbooking.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractService<Dto, Entity, ID> implements IService<Dto, ID> {

    @Autowired
    protected ModelMapper modelMapper;

    protected CrudRepository<Entity, ID> repository;

    protected AbstractService(CrudRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Dto> findAll() {
        return toDto(repository.findAll());
    }

    @Override
    public Dto findById(ID id) {
        Entity entity;
        try {
            entity = repository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException("Entity not found. Entity id: " + id.toString());
        }
        return toDto(entity);
    }

    @Override
    public Dto create(Dto dto) {
        Entity entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public Dto update(Dto dto) {
        Entity entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    protected abstract Dto toDto(Entity entity);

    protected abstract Entity toEntity(Dto dto);

    protected Iterable<Entity> toEntity(Iterable<Dto> dtos) {
        List<Entity> users = new ArrayList<>();
        for (Dto dto : dtos) {
            users.add(toEntity(dto));
        }
        return users;
    }

    protected Iterable<Dto> toDto(Iterable<Entity> entities) {
        List<Dto> dtos = new ArrayList<>();
        for (Entity entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}
