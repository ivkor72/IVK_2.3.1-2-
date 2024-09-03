package service;

import Dao.CarDao;
import Dao.CarDaoImpl;
import model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{

    private final CarDao carDao = new CarDaoImpl();

    @Override
    public  List<Cars> createCars() {
    return carDao.createCars();
    }

    @Override
    public List<Cars> getCars(Long count) {
        return carDao.getCars(count);
    }
}
