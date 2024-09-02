package com.kgisl.sb101.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb101.entity.Carcollections;
import com.kgisl.sb101.service.CarService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/car")
@RestController
public class CarController {
    

    {System.out.print("--------------------------Run--------------------------");}

    //@Autowired 
    private CarService carService;
    public CarController(CarService carService){
        this.carService = carService;
    }
   
    @GetMapping("/list")
    public ResponseEntity<List<Carcollections>> getAllCars() {
        List<Carcollections> car = carService.getAllCars();
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Carcollections> createCar(@RequestBody Carcollections car) {
        Carcollections createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }
    



    @GetMapping("/{id}")
    public ResponseEntity<Carcollections> getCarById(@PathVariable int id) {
        Carcollections car = carService.getCarById(id);
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        return new ResponseEntity<>(car, car != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carcollections> updateCar(@PathVariable int id, @RequestBody Carcollections updatedcar) {
        Carcollections car = carService.updateCar(id, updatedcar);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") int id) {
        if (carService.getCarById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
