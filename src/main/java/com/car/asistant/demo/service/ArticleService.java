package com.car.asistant.demo.service;
import com.car.asistant.demo.request.ArticlePostDto;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

void addArticle(ArticlePostDto articlePostDto);


}
