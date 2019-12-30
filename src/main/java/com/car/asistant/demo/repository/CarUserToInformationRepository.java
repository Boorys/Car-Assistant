package com.car.asistant.demo.repository;

import com.car.asistant.demo.entity.CarUserToInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarUserToInformationRepository extends JpaRepository<CarUserToInformationEntity, String>
{
    List<CarUserToInformationEntity> findAll();

}
