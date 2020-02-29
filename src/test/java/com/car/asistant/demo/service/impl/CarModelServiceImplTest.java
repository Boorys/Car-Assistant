package com.car.asistant.demo.service.impl;



import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.service.CarModelService;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;


@ExtendWith(MockitoExtension.class)
public class CarModelServiceImplTest {


    @Mock
    private CarModelRepository carModelRepository;
    @Mock
    private CarModelMapper carModelMapper;
    @Mock
    private Utils utils;
    @Mock
    private CarUserRepository carUserRepository;
    @Spy
    @InjectMocks
    private CarModelServiceImpl carModelService= new CarModelServiceImpl(carModelRepository,carModelMapper,utils,carUserRepository);


    @Test
    public void createCarModelShouldCreationTest() {

        //given
        CarModelPostDto carModelPostDto = new CarModelPostDto();
        carModelPostDto.setModel("model");
        carModelPostDto.setOil(4);
        carModelPostDto.setBrakePads(5);
        carModelPostDto.setCarBrand("brand");
        carModelPostDto.setTimingGear(4);
        given(carModelRepository.findByModel(anyString())).willReturn(null);
        given(utils.generateUserId(anyInt())).willReturn("dsfsdfsdf");
        given(carModelMapper.carModelPostDtoToCarModelEntity(any((CarModelPostDto.class)))).willReturn(new CarModelEntity());
        //when
        //then
        assertDoesNotThrow(() ->  carModelService.createCarModel(carModelPostDto));
    }


}
