package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.CarUserToInformationEntity;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;

@Service
public interface SendMessageService {

void sendEmail(CarUserToInformationEntity carUserToInformationEntities) throws MessagingException;


}
