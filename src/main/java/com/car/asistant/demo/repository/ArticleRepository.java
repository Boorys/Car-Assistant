package com.car.asistant.demo.repository;

import com.car.asistant.demo.entity.ArticleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository  extends PagingAndSortingRepository<ArticleEntity, String> {



}
