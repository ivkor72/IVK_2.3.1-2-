package Dao;

import model.Cars;

import java.util.List;

public interface CarDao {

    List<Cars> createCars ();
    List <Cars> getCars (Long count);

}
