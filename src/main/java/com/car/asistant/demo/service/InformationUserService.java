package com.car.asistant.demo.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;


@Service
public interface InformationUserService {


    void sendInformationToUser() throws MessagingException;


}
