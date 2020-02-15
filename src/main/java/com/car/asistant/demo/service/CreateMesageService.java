package com.car.asistant.demo.service;

import com.car.asistant.demo.response.CarUserToInformationDto;
import org.springframework.stereotype.Service;

@Service
public interface CreateMesageService {

String createInformationMessage(CarUserToInformationDto carUserToInformationDto);

}
