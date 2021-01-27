package com.airbooking.bl.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper<Dto, Entity> implements IMapper<Dto, Entity>{
    @Autowired
    protected ModelMapper modelMapper;
}
