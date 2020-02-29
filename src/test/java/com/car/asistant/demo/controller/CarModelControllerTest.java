package com.car.asistant.demo.controller;


import com.car.asistant.demo.mapper.CarModelMapper;
//import com.car.asistant.demo.request.CarModelRequestModel;
//import com.car.asistant.demo.response.CarModelRest;
import com.car.asistant.demo.request.CarModelPostDto;
import com.car.asistant.demo.service.CarModelService;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/*
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class CarModelControllerTest {


    CarModelService carModelService;
    CarModelMapper carModelMapper;
    CarModelController carModelController;


    @Before
    public void init() {
        carModelService = mock(CarModelService.class);
        carModelMapper = mock(CarModelMapper.class);
        carModelController = new CarModelController(carModelService, carModelMapper);
    }


    @Test
    public void createCarModelTest()
    {

        //given
        CarModelPostDto carModelPostDto = new CarModelPostDto();
       // carModelPostDto.setCarModelId("carUserId");
        CarModelRequestModel carModelRequestModel = new CarModelRequestModel();
        //CarModelDto carModelDto = new CarModelDto();
       // carModelDto.setCarModelId("carUserId");
        //when
     //   when(carModelMapper.carModelRequestModelToCarModelDto(carModelRequestModel)).thenReturn(carModelDto);
     //   when(carModelService.createCarModel(carModelDto)).thenReturn(carModelDto);
    //    when(carModelMapper.carModelDtoToCarModelRest(carModelDto)).thenReturn(carModelRest);

        //then
       // Assert.assertEquals(carModelController.createCarModel(carModelRequestModel).getCarModelId(), carModelDto.getCarModelId());
        carModelController.perform(get("/toto")).andExpect(status().isOk());
    }

    @Test
    public void getUserTest() {
        //given
     //   CarModelRest carModelRest = new CarModelRest();
    //    CarModelDto carModelDto = new CarModelDto();
    //    List<CarModelDto> list = new ArrayList<>();
     //   list.add(carModelDto);
    //    list.add(carModelDto);
     //   list.add(carModelDto);

        //when
      //  when(carModelService.getAllCarModel(0, 10)).thenReturn(list);
      //  when(carModelMapper.carModelDtoToCarModelRest(carModelDto)).thenReturn(carModelRest);

        //then
    //    Assert.assertEquals(carModelController.getUser().size(), list.size());

    }

*/
//}
