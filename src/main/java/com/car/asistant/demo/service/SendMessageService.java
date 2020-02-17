package com.car.asistant.demo.service;


import com.car.asistant.demo.entity.CarUserToInformationEntity;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;

@Service
public interface SendMessageService {

void sendEmailAboutRepair(CarUserToInformationEntity carUserToInformationEntities) throws MessagingException;
void sendEmail(String message,String email) throws MessagingException;


}
