package com.car.asistant.demo.repository;

import com.car.asistant.demo.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface ArticleRepository extends CrudRepository<ArticleEntity, String> {

    List<ArticleEntity> findAll();

}
