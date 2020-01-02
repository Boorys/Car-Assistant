package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.CarUserToInformationEntity;
import javax.mail.MessagingException;
import org.springframework.stereotype.Service;


@Service
public interface SendMessageService {

void sendEmail(CarUserToInformationEntity carUserToInformationEntities) throws MessagingException;


}
