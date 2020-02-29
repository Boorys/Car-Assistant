package com.car.asistant.demo.repository;


import com.car.asistant.demo.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);

    UserEntity findByFirstName(String firstName);


}
