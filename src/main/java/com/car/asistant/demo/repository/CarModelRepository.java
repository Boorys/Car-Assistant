package com.car.asistant.demo.repository;


import com.car.asistant.demo.entity.CarModelEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends PagingAndSortingRepository<CarModelEntity, Long> {

}
