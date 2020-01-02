package com.car.asistant.demo.controller;


import com.car.asistant.demo.dto.CarUserDto;
import com.car.asistant.demo.dto.UserDto;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.request.CarUserRequestModel;
import com.car.asistant.demo.request.UserDetailsRequsetModel;
import com.car.asistant.demo.response.UserRest;
import com.car.asistant.demo.service.CarUserService;
import com.car.asistant.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    CarUserService carUserService;
    CarUserMapper carUserMapper;

    @Autowired
    public UserController(UserService userService, CarUserService carUserService, CarUserMapper carUserMapper) {
        this.userService = userService;
        this.carUserService = carUserService;
        this.carUserMapper = carUserMapper;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequsetModel userDetails) {
        UserRest userRest = new UserRest();
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = new UserDto();
        UserDto createdUserDto = new UserDto();
        userDto = modelMapper.map(userDetails, UserDto.class);
        createdUserDto = userService.createUser(userDto);
        userRest = modelMapper.map(createdUserDto, UserRest.class);

        return userRest;
    }


    @PostMapping(path = "/{addCar}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserRest addCarUser(@RequestBody CarUserRequestModel carUserRequestModel) {

        ModelMapper modelMapper = new ModelMapper();
        CarUserDto carUserDto = new CarUserDto();
        carUserDto = carUserMapper.carUserRequestModelToCarUserDto(carUserRequestModel);

        UserDto userDto = new UserDto();
        userDto = carUserService.createCarUser(carUserDto);
        UserRest userRest = new UserRest();
        BeanUtils.copyProperties(userDto, userRest);
        return userRest;
    }

    @GetMapping(path = "/showUser/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id) {
        UserRest userRest = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        ModelMapper modelMapper = new ModelMapper();
        userRest = modelMapper.map(userDto, UserRest.class);

        return userRest;
    }


}
