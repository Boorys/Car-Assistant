package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.entity.CarUserToInformationEntity;
import com.car.asistant.demo.mapper.CarUserToInformationMapper;
import com.car.asistant.demo.response.CarUserToInformationDto;
import com.car.asistant.demo.service.CreateMesageService;
import com.car.asistant.demo.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class SendMessageImpl implements SendMessageService {


    private JavaMailSender javaMailSender;
    private CreateMesageService createMesageService;
    private CarUserToInformationMapper carUserToInformationMapper;

    @Autowired
    public SendMessageImpl(JavaMailSender javaMailSender, CreateMesageService createMesageService, CarUserToInformationMapper carUserToInformationMapper) {
        this.javaMailSender = javaMailSender;
        this.createMesageService = createMesageService;
        this.carUserToInformationMapper = carUserToInformationMapper;
    }

    @Override
    public void sendEmail(CarUserToInformationEntity carUserToInformationEntity) throws MessagingException {

        String message;
        CarUserToInformationDto carUserToInformationDto;
        carUserToInformationDto = carUserToInformationMapper.carUserToInformationEntityToCarUserToInformationDto(carUserToInformationEntity);
        message = createMesageService.createInformationMessage(carUserToInformationDto);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(carUserToInformationEntity.getEmail());
        mimeMessageHelper.setSubject("Czas na przegląd cześci w twoim samochodzie");
        mimeMessageHelper.setText(message, true);
        javaMailSender.send(mimeMessage);

    }


}
