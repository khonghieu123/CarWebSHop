package com.javawebcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javawebcar.model.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {  // Sửa thành Long, vì carID là Long
    List<Car> findAll();

    <S extends Car> S saveAndFlush(S entity);

    @Query("SELECT c FROM Car c WHERE " +
           "(:filter1 IS NULL OR c.name LIKE %:filter1%) AND " +
           "(:filter2 IS NULL OR c.model LIKE %:filter2%) AND " +
           "(:filter3 IS NULL OR c.fuel LIKE %:filter3%)")
    List<Car> findAllByKeywords(String filter1, String filter2, String filter3);

    void delete(Car car);

    @Override
    void flush();

    Optional<Car> findCarByRegistrationNumber(String registrationNumber);
}
