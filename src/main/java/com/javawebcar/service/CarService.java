package com.javawebcar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebcar.model.Car;
import com.javawebcar.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Lấy danh sách tất cả các xe
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    // Tìm kiếm xe theo các từ khóa
    public List<Car> findAllByKeywords(String filter1, String filter2, String filter3) {
        filter1 = filter1 != null && !filter1.isEmpty() ? filter1 : null;
        filter2 = filter2 != null && !filter2.isEmpty() ? filter2 : null;
        filter3 = filter3 != null && !filter3.isEmpty() ? filter3 : null;
        return carRepository.findAllByKeywords(filter1, filter2, filter3);
    }

    // Thêm một xe mới
    public boolean addCar(Car car) {
        Optional<Car> existingCar = carRepository.findCarByRegistrationNumber(car.getRegistrationNumber());
        if (existingCar.isEmpty()) {
            carRepository.saveAndFlush(car);
            return true; // Thêm thành công
        }
        return false; // Xe đã tồn tại
    }

    // Sửa đổi thông tin xe
    public boolean modifyCar(Car car) {
        Optional<Car> existingCar = carRepository.findCarByRegistrationNumber(car.getRegistrationNumber());
        if (existingCar.isPresent()) {
            carRepository.saveAndFlush(car);
            return true; // Sửa đổi thành công
        }
        return false; // Xe không tồn tại
    }

    // Xóa một xe
    public boolean deleteCar(Car car) {
        Optional<Car> existingCar = carRepository.findCarByRegistrationNumber(car.getRegistrationNumber());
        if (existingCar.isPresent()) {
            carRepository.delete(existingCar.get());
            carRepository.flush();
            return true; // Xóa thành công
        }
        return false; // Xe không tồn tại
    }
}
