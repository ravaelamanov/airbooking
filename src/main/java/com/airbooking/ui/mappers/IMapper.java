package com.airbooking.ui.mappers;

import java.util.ArrayList;
import java.util.List;

public interface IMapper<ResponseModel, RequestModel, Dto> {
    ResponseModel toResponseModel(Dto dto);

    Dto toDto(RequestModel requestModel);

    default Iterable<ResponseModel> toResponseModel(Iterable<Dto> dtos) {
        List<ResponseModel> users = new ArrayList<>();
        for (Dto dto : dtos) {
            users.add(toResponseModel(dto));
        }
        return users;
    }

    default Iterable<Dto> toDto(Iterable<RequestModel> requestModels) {
        List<Dto> dtos = new ArrayList<>();
        for (RequestModel entity : requestModels) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
