package com.car.asistant.demo.service;

import com.car.asistant.demo.request.ArticlePostDto;
import com.car.asistant.demo.response.ArticleGetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    void addArticle(ArticlePostDto articlePostDto);

    List<ArticleGetDto> getArticles();

}
