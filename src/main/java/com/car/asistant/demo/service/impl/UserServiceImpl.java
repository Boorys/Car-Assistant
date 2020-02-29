package com.car.asistant.demo.service.impl;


import com.car.asistant.demo.entity.UserEntity;
import com.car.asistant.demo.exception.UserExistException;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.kit.VerificationToken;
import com.car.asistant.demo.kit.VerivicationMessage;
import com.car.asistant.demo.mapper.UserMapper;
import com.car.asistant.demo.repository.UserRepository;
import com.car.asistant.demo.request.UserPostDto;
import com.car.asistant.demo.response.UserGetDto;
import com.car.asistant.demo.response.UserSimpleGetDto;
import com.car.asistant.demo.service.SendMessageService;
import com.car.asistant.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private UserMapper userMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Utils utils;
    private SendMessageService sendMessageService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder, Utils utils, SendMessageService sendMessageService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.utils = utils;
        this.sendMessageService = sendMessageService;
    }


    public UserServiceImpl() {
    }

    @Override
    public UserGetDto getUser(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        UserGetDto returnValue = new UserGetDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }


    @Override
    public UserEntity createUser(UserPostDto userPostDto) throws MessagingException {


        UserEntity userEntity;

        userEntity = userRepository.findByEmail(userPostDto.getEmail());
        if (userEntity != null) {
            throw new UserExistException(userPostDto.getEmail());
        }
        userEntity = new UserEntity();
        userEntity = userMapper.userPostDtoToUserEntity(userPostDto);
        String password = bCryptPasswordEncoder.encode(userPostDto.getPassword());
        userEntity.setEncryptedPassword(password);
        String publicUserId = utils.generateUserId(10);
        userEntity.setUserId(publicUserId);
        userEntity.setRole("USER");
        userEntity.setEnabled(false);
        //send email
        VerificationToken verificationToken = new VerificationToken();
        VerivicationMessage verivicationMessage = new VerivicationMessage();
        String message = verivicationMessage.createMessage(verificationToken.calculateExpiryDate(1, publicUserId).toString());
        sendMessageService.sendEmail(message, userPostDto.getEmail());


        userRepository.save(userEntity);

        return userEntity;
    }

    @Override
    public UserSimpleGetDto getUserByUserId(String userId) {

        UserEntity userEntity = userRepository.findByUserId(userId);
        UserSimpleGetDto userSimpleGetDto;
        userSimpleGetDto = userMapper.userEntityToUserSimpleGetDto(userEntity);

        return userSimpleGetDto;
    }

    @Override
    public void verificationUser(String token) throws Exception ,UsernameNotFoundException{

        String stringDate = token.substring(0, 9);
        String userId = token.substring(10, 20);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(stringDate);
        Calendar cal = Calendar.getInstance();
        UserEntity userEntity;

        if (!((date.getTime() - cal.getTime().getTime()) <= 0)) {
            throw new Exception();
        }
        userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) {
            throw new UsernameNotFoundException("user");
        }
        userEntity.setEnabled(true);
        userRepository.save(userEntity);

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);


        if (userEntity == null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());


    }
}
