package com.car.asistant.demo.controller;

import com.car.asistant.demo.dto.UserDto;
import com.car.asistant.demo.mapper.CarUserMapper;
import com.car.asistant.demo.request.UserDetailsRequsetModel;
import com.car.asistant.demo.service.CarUserService;
import com.car.asistant.demo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {


UserService userService;

CarUserService carUserService;

CarUserMapper carUserMapper;

UserController userController;



    @Before
public void init()
{
    userService = mock(UserService.class);
    carUserService = mock(CarUserService.class);
    carUserMapper = mock(CarUserMapper.class);
    userController = spy(new UserController(userService,carUserService,carUserMapper));
}

@Test
public void createUserTest()
{
    UserDto userDto = new UserDto();
    userDto.setFirstName("tom");
    UserDetailsRequsetModel userDetailsRequsetModel = new UserDetailsRequsetModel();


    when(userService.createUser(any(UserDto.class))).thenReturn(userDto);

    userController.createUser(userDetailsRequsetModel);
    Assert.assertEquals(userController.createUser(userDetailsRequsetModel).getFirstName(),userDto.getFirstName());

}






}
