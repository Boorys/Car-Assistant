package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    UserRepository userRepository;
    UserMapper userMapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    Utils utils;
    UserServiceImpl userService;

    @Before
    public void init() {
        userRepository = mock(UserRepository.class);
        userMapper = mock(UserMapper.class);
        bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
        utils = mock(Utils.class);
        userService = spy(new UserServiceImpl(userRepository, userMapper, bCryptPasswordEncoder, utils));
    }

    @Test
    public void getUserTest() {

        //given
        String email = "email";
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Tom");
        //when
        when(userRepository.findByEmail(email)).thenReturn(userEntity);
        //then
        Assert.assertEquals(userService.getUser(email).getFirstName(), "Tom");
    }

    @Test(expected = UsernameNotFoundException.class)
    public void getUserExceptionTest() {

        //given
        String email = "email";
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Tom");
        //when
        when(userRepository.findByEmail(email)).thenReturn(userEntity);
        //then
        userService.getUser("");
    }

    @Test
    public void createUserTest() {
        //given
     /*   UserDto userDto = new UserDto();
        userDto.setFirstName("Tom");
        UserEntity userEntity = new UserEntity();
        //when
        when(userMapper.userDtoToUserEntity(userDto)).thenReturn(userEntity);
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn("asasasasasa");
        when(utils.generateUserId(anyInt())).thenReturn("dsfsdfsdf");
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapper.userEntityToUserDto(any(UserEntity.class))).thenReturn(userDto);
        //then
      //  Assert.assertEquals(userService.createUser(userDto).getFirstName(), "Tom");*/

    }

    @Test
    public void getUserByUserIdTest()
    {
/*String userId="id";
UserEntity userEntity = new UserEntity();
UserDto userDto = new UserDto();
userDto.setFirstName("Tom");

        when(userRepository.findByUserId(userId)).thenReturn(userEntity);
        when(userMapper.userEntityToUserDto(userEntity)).thenReturn(userDto);
        Assert.assertEquals(userService.getUserByUserId(userId).getFirstName(),"Tom");
*/
    }

    @Test(expected = UsernameNotFoundException.class)
    public void getUserByUserIdExceptionTest()
    {
     /*   String userId="id";
        UserEntity userEntity = new UserEntity();
        UserDto userDto = new UserDto();
        userDto.setFirstName("Tom");

        when(userRepository.findByUserId(userId)).thenReturn(userEntity);
        when(userMapper.userEntityToUserDto(userEntity)).thenReturn(userDto);
       userService.getUserByUserId("").getFirstName();
*/
    }

    @Test
    public void loadUserByUsername()
    {
        String email = "email";
        String password = " pass";
        String encrypted ="aaasasas";
        UserEntity userEntity = new UserEntity();
       userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setEncryptedPassword(encrypted);
        when(userRepository.findByEmail(email)).thenReturn(userEntity);

      Assert.assertEquals(userService.loadUserByUsername(email).getPassword(),encrypted);

    }


}
