package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.exception.UserExistException;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.kit.VerificationToken;
import com.car.asistant.demo.kit.VerivicationMessage;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserGetDto;
import com.car.asistant.demo.service.SendMessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.mail.MessagingException;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    @Spy
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private Utils utils;
    @Mock
    private VerivicationMessage verivicationMessage;
    @Mock
    private SendMessageService sendMessageService;

    @Test
    public void getUserShouldReturnUserGetDtoTest() {

        //given
        given(userRepository.findByEmail(anyString())).willReturn(new UserEntity());

        //when
        UserGetDto userGetDto = userServiceImpl.getUser(anyString());

        //then
        assertThat(userGetDto.getClass(), equalTo(UserGetDto.class));
    }

    @Test
    public void getUserShouldNotReturnUserGetDtoTest() {

        //given
        given(userRepository.findByEmail(anyString())).willReturn(null);

        //when
        //then
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.getUser(anyString()));
    }

    @Test
    public void createUserShouldCreationTest() throws MessagingException {
        //given

        UserEntity userEntity = new UserEntity();
        UserPostDto userPostDto = new UserPostDto();
        userPostDto.setEmail("email");
        userPostDto.setPassword("123");
        given(userMapper.userPostDtoToUserEntity(userPostDto)).willReturn(userEntity);
        userEntity.setFirstName("Tom");


        //when

        userEntity = userServiceImpl.createUser(userPostDto);

        //then

        assertThat(userEntity.getFirstName(), equalTo("Tom"));
    }

    @Test
    public void createUserShouldNotCreationTest() {

        //given
        UserPostDto userPostDto = new UserPostDto();
        userPostDto.setEmail("email");
        given(userRepository.findByEmail("email")).willReturn(new UserEntity());

        //when
        //then
        assertThrows(UserExistException.class, () -> userServiceImpl.createUser(userPostDto));
    }


    @Test
    public void verificationUserPositiveTest() {

        //given
        VerificationToken verificationToken = new VerificationToken();
        String userId = "sdfsdf";
        String token = verificationToken.calculateExpiryDate(2, userId);
        given(userRepository.findByUserId(anyString())).willReturn(new UserEntity());

        //when
        //then
        assertDoesNotThrow(() -> userServiceImpl.verificationUser(token));
    }

    @Test
    public void verificationUserThrowUsernameNotFoundExceptionTest() {
        //given
        VerificationToken verificationToken = new VerificationToken();
        String userId = "sdfsdf";
        String token = verificationToken.calculateExpiryDate(2, userId);
        given(userRepository.findByUserId(anyString())).willReturn(null);

        //when
        //then
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.verificationUser(token));
    }

}