package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.dto.CarUserToInformationDto;
import com.car.asistant.demo.service.CreateMesageService;

import org.springframework.stereotype.Service;


@Service
public class CreateMesageImpl implements CreateMesageService {


   @Override
    public String createInformationMessage(CarUserToInformationDto carUserToInformationDto) {

        String message;

        message = "<h1>Witaj " + carUserToInformationDto.getFirstName() + "<h1><br><br><br>"
                + "Twój " + carUserToInformationDto.getCarModel() + " wymaga: ";
        if (carUserToInformationDto.getOil() == 1) {
            message = message + "wymiany oleju ";
        }
        if (carUserToInformationDto.getTimingGear() == 1)
        {
            message = message + "przeglądu skrzyni biegów ";
        }
        if (carUserToInformationDto.getBreakPads() == 1) {
            message = message + " wymiany klocków hamulcowych";
        }

        message = message+"<br><br><br> <h3>Pozdrawia zespół Car Assistant<h3>";

        return   message ;

    }


}
