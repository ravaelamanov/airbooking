package com.airbooking.ui.mappers;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper<ResponseModel, RequestModel, Dto> implements IMapper<ResponseModel, RequestModel, Dto>{
    @Autowired
    protected ModelMapper modelMapper;

    protected void setupMapper() {}

    protected Converter<Dto, ResponseModel> dtoResponseModelConverter() {
        return mappingContext -> {
            Dto dto = mappingContext.getSource();
            ResponseModel responseModel = mappingContext.getDestination();
            dtoResponseModelCustomMapping(dto, responseModel);
            return mappingContext.getDestination();
        };
    }

    protected Converter<RequestModel, Dto> requestModelDtoConverter() {
        return mappingContext -> {
            RequestModel requestModel = mappingContext.getSource();
            Dto dto = mappingContext.getDestination();
            requestModelDtoCustomMapping(requestModel, dto);
            return mappingContext.getDestination();
        };
    }

    protected void dtoResponseModelCustomMapping(Dto dto, ResponseModel responseModel) {}

    protected void requestModelDtoCustomMapping(RequestModel requestModel, Dto dto) {}

}
