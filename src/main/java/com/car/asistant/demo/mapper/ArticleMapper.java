package com.car.asistant.demo.mapper;

import com.car.asistant.demo.entity.ArticleEntity;
import com.car.asistant.demo.request.ArticlePostDto;
import com.car.asistant.demo.response.ArticleGetDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleEntity articlePostDtoToArticleEntity(ArticlePostDto articlePostDto);

    ArticleGetDto articleEntityToArticleGetDto(ArticleEntity articleEntity);

}
