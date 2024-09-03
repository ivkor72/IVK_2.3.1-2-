package web.controller;

import model.Cars;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;


import java.util.List;

@Controller
public class CarController {

    private CarService carService = new CarServiceImpl();



    @GetMapping(value = "/cars")
    public String Cars(@RequestParam(defaultValue = "5", value = "carsCount") Long carsCount, Model model) {
        if (carsCount > 5 | carsCount <=0) carsCount = Long.valueOf(5);
        List<Cars> carsList = carService.getCars(carsCount);
        model.addAttribute("carsList", carsList);
        return "cars";
    }

}
