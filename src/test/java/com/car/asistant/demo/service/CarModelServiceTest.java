package com.car.asistant.demo.service;

/*
import com.car.asistant.demo.entity.CarModelEntity;
import com.car.asistant.demo.entity.CarUserEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.CarModelMapper;
import com.car.asistant.demo.repository.CarModelRepository;
import com.car.asistant.demo.repository.CarUserRepository;
import com.car.asistant.demo.service.impl.CarModelServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
/*
@RunWith(MockitoJUnitRunner.class)
public class CarModelServiceTest {


    CarModelRepository carModelRepository;
    CarModelMapper carModelMapper;
    Utils utils;
    CarUserRepository carUserRepository;
    CarModelServiceImpl carModelService;

    @Before
    public void init() {

        carModelRepository = mock(CarModelRepository.class);
        carModelMapper = mock(CarModelMapper.class);
        utils = mock(Utils.class);
        carUserRepository = mock(CarUserRepository.class);
        carModelService = spy(new CarModelServiceImpl(carModelRepository,carModelMapper,utils,carUserRepository));
    }


    @Test
    public void createCarModelTest()
    {
        CarUserEntity carUserEntity = new CarUserEntity();
      //  CarModelDto carModelDto = new CarModelDto();
      //  carModelDto.setCarUserId("");
      //  carModelDto.setCarModelId("");
        CarModelEntity carModelEntity = new CarModelEntity();


        when(carUserRepository.findByCarUserId(anyString())).thenReturn(carUserEntity);
        when(utils.generateUserId(anyInt())).thenReturn("");
     //   when(carModelMapper.carModelDtoToCarModelEntity(carModelDto)).thenReturn(carModelEntity);
       // carModelService.createCarModel(carModelDto);

       // Assert.assertEquals(carModelService.createCarModel(carModelDto).getCarModelId(),"");

    }

    @Test
    public void getAllCarModelTest()
    {

        CarModelEntity carModelEntity = new CarModelEntity();
      //  CarModelDto carModelDto = new CarModelDto();
        Pageable pagableRequest = PageRequest.of(5, 5);
        List list = new ArrayList();
        Page<CarModelEntity> carModelEntityPage = new PageImpl<>(list,pagableRequest,list.size());
        when(carModelRepository.findAll(pagableRequest)).thenReturn(carModelEntityPage);
   //    when(carModelMapper.carModelEntityToCarModelDto(carModelEntity)).thenReturn(carModelDto);

    //    Assert.assertEquals(carModelService.getAllCarModel(5,5).size(),0);

    }


*/
/*}
*/