package com.car.asistant.demo.controller;


import com.car.asistant.demo.request.ArticlePostDto;
import com.car.asistant.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page")
@CrossOrigin
public class AdminManagementController {


    private ArticleService articleService;

    @Autowired
    public AdminManagementController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(path = "/add/article", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Add article")
    public void addArticle(@RequestBody ArticlePostDto articlePostDto) {
        articleService.addArticle(articlePostDto);

    }



}
