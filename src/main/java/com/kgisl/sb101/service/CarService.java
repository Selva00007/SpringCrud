package com.kgisl.sb101.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.kgisl.sb101.entity.Carcollections;
import com.kgisl.sb101.repository.CarRepository;
@EnableAspectJAutoProxy
@Service
public class CarService{
 
    @Autowired
    private CarRepository carRepository;
 
    public List<Carcollections> getAllCars() {
        return carRepository.findAll();
    }
 
    public Carcollections createCar(Carcollections car) {
        return carRepository.save(car);
    }

    public Carcollections getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public Carcollections updateCar(int id, Carcollections updatedcar) {
        Carcollections car = carRepository.findById(id).orElse(null);
        if (car != null) {
            return carRepository.save(updatedcar);
        }
        return null;
    }
 
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }}