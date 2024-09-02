package com.kgisl.sb101.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kgisl.sb101.entity.Carcollections;
import com.kgisl.sb101.service.CarService;

/**
 * PersonController
 */

@ExtendWith(MockitoExtension.class)

public class CarControllerTest {
  @Mock
  private CarService carService;

  @InjectMocks
  private CarController personController;

  public static List<Carcollections> expected;
  
  Carcollections car1 = new Carcollections(1,24,"selva","2024-08-15","bmw");
  Carcollections car2 = new Carcollections(2,18,"dhanush","2024-08-15","benz");

  // public Person car2 = new PersonBuilder().id(2L).name("aravinth").build();

  @Test
  public void getallCarsTest() {

    expected = Arrays.asList(car1, car2);
    System.out.println(expected);
    when(carService.getAllCars()).thenReturn(expected);
    ResponseEntity<List<Carcollections>> actual = personController.getAllCars();
    assertNotNull(actual);
    assertEquals(expected, actual.getBody());
    assertEquals(HttpStatus.OK, actual.getStatusCode());
  }

  @Test
  public void getCarByIdTest() {
    int id = 1;
    when(carService.getCarById(id)).thenReturn(null);
    ResponseEntity<Carcollections> actual = personController.getCarById(id);
    assertNotNull(actual);
  }

  @Test
  public void createCarTest() {
    when(carService.createCar(car1)).thenReturn(car1);
    personController.createCar(car1);
  }

  @Test
  public void updateCarTest() {
    // Person edit = new PersonBuilder().name("shanmugam").build();
    int id = 1;
    // when(carService.updatePerson(id, car1)).thenReturn(car1);
    ResponseEntity<Carcollections> actual = personController.updateCar(id, car1);
    assertNotNull(actual);
    System.out.println("Actual is  "+actual.getBody());
    System.out.println("expected-->" + expected);
    // assertEquals(edit, actual.getBody());
  }

  @Test
  public void deleteCarTest() {
    int id = 1;
    when(carService.getCarById(id)).thenReturn(car1);
    personController.deleteCar(id);
    verify(carService).deleteCar(id);
  }
}