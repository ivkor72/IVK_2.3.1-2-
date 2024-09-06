package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(defaultValue = "5", value = "carsCount") Long carsCount, ModelMap model) {
        if (carsCount > 5 | carsCount <= 0) carsCount = 5L;
        List<Car> carsList = carService.getCars(carsCount);
        model.addAttribute("carsList", carsList);
        return "cars";
    }
}
