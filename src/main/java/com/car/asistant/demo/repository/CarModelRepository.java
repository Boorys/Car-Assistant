package com.car.asistant.demo.repository;


import com.car.asistant.demo.entity.CarModelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarModelRepository extends PagingAndSortingRepository<CarModelEntity, Long> {

    CarModelEntity findById(long i);
    CarModelEntity findByCarModelId(String carModelId);
    List<CarModelEntity> findAll();

    @Query(value = "SELECT car_model_entity.car_brand, car_model_entity.model, car_user_entity.car_user_id from car_model_entity " +

           " inner join car_user_entity on car_user_entity.car_model= car_model_entity.id " +
           " inner join user_entity on user_entity.id = car_user_entity.users " +
           " where user_entity.user_id=:id", nativeQuery = true)
    List<Object[]> findCarModelByUserId(String id);


}
