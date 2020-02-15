package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.entity.CarUserToInformationEntity;
import com.car.asistant.demo.repository.CarUserToInformationRepository;
import com.car.asistant.demo.service.InformationUserService;
import com.car.asistant.demo.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
@EnableScheduling
public class InformationUserImpl implements InformationUserService {


    SendMessageService sendMessageService;
    CarUserToInformationRepository carUserToInformationRepository;

    @Autowired
    public InformationUserImpl(SendMessageService sendMessageService, CarUserToInformationRepository carUserToInformationRepository) {
        this.sendMessageService = sendMessageService;
        this.carUserToInformationRepository = carUserToInformationRepository;
    }





    //@Scheduled(cron = "1 1 1 1 * ?")//seconds, minutes, hours, days of the month, months and days of the week

    @Scheduled(fixedRate=1000)
   @Override
    public void sendInformationToUser() throws MessagingException {

        List<CarUserToInformationEntity> carUserToInformationEntityList = carUserToInformationRepository.findAll();

        for (CarUserToInformationEntity user : carUserToInformationEntityList) {
            System.out.println("wysyłam");
            sendMessageService.sendEmail(user);

        }

    }



}
