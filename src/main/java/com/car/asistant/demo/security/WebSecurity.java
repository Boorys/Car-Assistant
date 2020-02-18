package com.car.asistant.demo.security;

import com.car.asistant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
    .authorizeRequests()
               .antMatchers(HttpMethod.POST, "/users/login").permitAll()
                .antMatchers(HttpMethod.POST, "/users").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/users/addCar/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET, "/getUser/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/car/model/add/car/model").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/car/model").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET, "/car/model/get/model/**").hasAnyRole("ADMIN","USER")


                .anyRequest()
                .permitAll()
                .and()
                .addFilter(getAuthenticationFilter())
                .addFilter(new JwtFilter(authenticationManager(), userDetailsService))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }


    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager(),bCryptPasswordEncoder);
        filter.setFilterProcessesUrl("/users/login");
        return filter;
    }


}
