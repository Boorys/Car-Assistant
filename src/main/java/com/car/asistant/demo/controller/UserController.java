package com.car.asistant.demo.controller;

import com.car.asistant.demo.kit.VerificationToken;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.request.CarUserPostDto;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserSimpleGetDto;
import com.car.asistant.demo.service.CarUserService;
import com.car.asistant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RestController
@RequestMapping("/users")
@CrossOrigin
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

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Add user")
    public void createUser(@Valid @RequestBody UserPostDto userPostDto) throws Exception {

        userService.createUser(userPostDto);
    }


    @PostMapping(path = "/addCar/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Add car")
    public void addCarUser(@Valid @RequestBody CarUserPostDto carUserPostDto, @PathVariable String userId) {

        carUserService.createCarUser(carUserPostDto, userId);
    }

    @GetMapping(path = "/getUser/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserSimpleGetDto getUserByUserId(@PathVariable String userId) {

        UserSimpleGetDto userSimpleGetDto = userService.getUserByUserId(userId);
        return userSimpleGetDto;
    }




    @GetMapping(path="/verification/email/{token}")
    public ResponseEntity verificationEmail(@PathVariable String token) throws Exception {

        userService.verificationUser(token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "path");
        return new ResponseEntity(headers, HttpStatus.FOUND);
    }



}
