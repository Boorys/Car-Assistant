package com.car.asistant.demo.service;


import com.car.asistant.demo.dto.CarUserToInformationDto;
import org.springframework.stereotype.Service;

@Service
public interface CreateMesageService {

String createInformationMessage(CarUserToInformationDto carUserToInformationDto);

}
