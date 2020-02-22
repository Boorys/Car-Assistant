package com.car.asistant.demo.controller;


import com.car.asistant.demo.request.ArticlePostDto;
import com.car.asistant.demo.request.ContactPostDto;
import com.car.asistant.demo.response.ArticleGetDto;
import com.car.asistant.demo.service.ArticleService;
import com.car.asistant.demo.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/page")
@CrossOrigin
public class AdminManagementController {

    private Environment env;
    private ArticleService articleService;
    private SendMessageService sendMessageService;

    @Autowired
    public AdminManagementController(Environment env, ArticleService articleService, SendMessageService sendMessageService) {
        this.env = env;
        this.articleService = articleService;
        this.sendMessageService = sendMessageService;
    }

    @PostMapping(path = "/add/article", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Add article")
    public void addArticle(@RequestBody ArticlePostDto articlePostDto) {
        articleService.addArticle(articlePostDto);

    }

    @GetMapping(path = "/get/articles", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ArticleGetDto> getAerticles() {

        return articleService.getArticles();
    }

    @PostMapping(path = "/post/contact")
    @ResponseStatus(value = HttpStatus.OK, reason = "Send")
    public void sendContact(@RequestBody ContactPostDto contactPostDto) throws MessagingException {
       String email = env.getProperty("spring.mail.username");
       sendMessageService.sendEmail(contactPostDto.getAuthor(),email);

    }

}
