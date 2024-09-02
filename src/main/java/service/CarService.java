package service;

import model.Cars;

import java.util.List;

public interface CarService {

    List <Cars> createCars ();
    List <Cars> getCars (int count);

}
