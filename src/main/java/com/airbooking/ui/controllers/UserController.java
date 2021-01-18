package com.airbooking.ui.controllers;

import com.airbooking.bl.services.UserService;
import com.airbooking.ui.dto.UserDto;
import com.airbooking.ui.models.request.UserUpdateRequestModel;
import com.airbooking.ui.models.request.UserRequestModel;
import com.airbooking.ui.models.response.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<UserResponseModel> getUsers() {
        List<UserResponseModel> userResponseModels = new ArrayList<>();
        userService.findAll().forEach(userDto -> userResponseModels.add(modelMapper.map(userDto, UserResponseModel.class)));
        return userResponseModels;
    }

    @GetMapping(path = "/{userId}")
    public UserResponseModel getUser(@PathVariable Long userId) {
        return modelMapper.map(userService.findById(userId), UserResponseModel.class);
    }

    @PostMapping
    public UserResponseModel createUser(@Valid @RequestBody UserRequestModel userRequestModel) {
        UserDto userDto = userService.create(modelMapper.map(userRequestModel, UserDto.class));
        return modelMapper.map(userDto, UserResponseModel.class);
    }

    @PutMapping(path = "/{userId}")
    public UserResponseModel updateUser(@PathVariable Long userId,
                                        @Valid @RequestBody UserUpdateRequestModel userUpdateRequestModel) {
        UserDto userDto = userService.findById(userId);
        userDto.setName(userUpdateRequestModel.getName());
        return modelMapper.map(userService.update(userDto), UserResponseModel.class);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }

    //TODO:
    // - Learn response codes and set appropriate ones for the mappings
    // - Handle exceptions

}
