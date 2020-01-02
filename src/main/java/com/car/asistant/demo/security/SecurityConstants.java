package com.car.asistant.demo.security;

import com.car.asistant.demo.SpringApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


public class SecurityConstants {

	@Autowired
	private Environment env;

    public static final long EXPIRATION_TIME = 864000000;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/users";

    public static String getTokenSecret()
	{
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }

}
