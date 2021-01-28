package com.airbooking.bl.mappers;

import java.util.ArrayList;
import java.util.List;

public interface IMapper<Dto, Entity> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    default Iterable<Entity> toEntity(Iterable<Dto> dtos) {
        List<Entity> users = new ArrayList<>();
        for (Dto dto : dtos) {
            users.add(toEntity(dto));
        }
        return users;
    }

    default Iterable<Dto> toDto(Iterable<Entity> entities) {
        List<Dto> dtos = new ArrayList<>();
        for (Entity entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
