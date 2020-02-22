package com.car.asistant.demo.service.impl;

import com.car.asistant.demo.entity.ArticleEntity;
import com.car.asistant.demo.kit.Utils;
import com.car.asistant.demo.mapper.ArticleMapper;
import com.car.asistant.demo.repository.ArticleRepository;
import com.car.asistant.demo.request.ArticlePostDto;
import com.car.asistant.demo.response.ArticleGetDto;
import com.car.asistant.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {


    private Utils utils;
    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(Utils utils, ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.utils = utils;
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }


    @Override
    public void addArticle(ArticlePostDto articlePostDto) {

        ArticleEntity articleEntity = new ArticleEntity();
        String articleId = utils.generateUserId(10);
        articleEntity = articleMapper.articlePostDtoToArticleEntity(articlePostDto);
        articleEntity.setArticleId(articleId);
        Date date = new Date();
        articleEntity.setDate(date);
        articleRepository.save(articleEntity);

    }

    @Override
    public List<ArticleGetDto> getArticles() {

        List<ArticleEntity> articleEntityList;
        List<ArticleGetDto> articleGetDtoList;
        articleEntityList = articleRepository.findAll();

        articleGetDtoList = articleEntityList.stream()
                .map(x -> articleMapper.articleEntityToArticleGetDto(x))
                .sorted((o2,o1)->o1.getDate().compareTo(o2.getDate()))
                .collect(Collectors.toList());

        return articleGetDtoList;
    }
}
