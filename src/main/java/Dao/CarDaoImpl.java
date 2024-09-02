package Dao;

import model.Cars;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class CarDaoImpl implements CarDao {

    private static final List<Cars> cars = new ArrayList<>();

    @Override
    public List<Cars> createCars() {
        Cars car1;

        car1 = new Cars("VOLVO","S-60", "red");
        cars.add(car1);
        car1 = new Cars("VOLVO","S-80", "green");
        cars.add(car1);
        car1 = new Cars("BMW","230", "yellow");
        cars.add(car1);
        car1 = new Cars("AUDI","A-6", "yellow");
        cars.add(car1);
        car1 = new Cars("VolksWagen","B-5", "white");
        cars.add(car1);

        return cars;
    }

    @Override
    public List<Cars> getCars(int count) {
        try {
            createCars();
        }
        catch (Exception e) {
        }
        return cars.subList(0, count);
    }
}
