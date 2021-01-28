package com.airbooking.bl.mappers;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper<Dto, Entity> implements IMapper<Dto, Entity>{
    @Autowired
    protected ModelMapper modelMapper;

    protected void setupMapper() {}

    protected Converter<Dto, Entity> dtoEntityConverter() {
        return mappingContext -> {
            Dto dto = mappingContext.getSource();
            Entity entity = mappingContext.getDestination();
            dtoEntityCustomMapping(dto, entity);
            return mappingContext.getDestination();
        };
    }

    protected Converter<Entity, Dto> entityDtoConverter() {
        return mappingContext -> {
            Entity entity = mappingContext.getSource();
            Dto dto = mappingContext.getDestination();
            entityDtoCustomMapping(entity, dto);
            return mappingContext.getDestination();
        };
    }

    protected void dtoEntityCustomMapping(Dto dto, Entity entity) {}

    protected void entityDtoCustomMapping(Entity entity, Dto dto) {}
}
