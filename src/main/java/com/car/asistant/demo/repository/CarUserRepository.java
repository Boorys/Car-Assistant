package com.car.asistant.demo.repository;



import com.car.asistant.demo.entity.CarUserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarUserRepository extends PagingAndSortingRepository<CarUserEntity, String> {



    CarUserEntity findByCarUserId(String carUserId);


}
