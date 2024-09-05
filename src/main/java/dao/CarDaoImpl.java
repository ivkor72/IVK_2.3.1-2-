package dao;

import model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private static final List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> createCars() {
        cars.add(new Car("VOLVO", "S-60", "red"));
        cars.add(new Car("VOLVO", "S-80", "green"));
        cars.add(new Car("BMW", "230", "yellow"));
        cars.add(new Car("AUDI", "A-6", "yellow"));
        cars.add(new Car("VolksWagen", "B-5", "white"));
        return cars;
    }
    @Override
    public List<Car> getCars(Long count) {
        if (cars.isEmpty()) createCars();
        return cars.subList(0, Math.toIntExact(count));
    }
}
