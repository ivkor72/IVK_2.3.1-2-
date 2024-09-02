package web.controller;

import model.Cars;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;


import java.util.List;

@Controller
public class CarsController {

    CarService carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String Cars(@RequestParam(defaultValue = "5", value = "carsCount") String carsCount, Model model) {
        int carsCountInt = Integer.parseInt(carsCount);
        if (carsCountInt > 5 | carsCountInt <=0) carsCountInt = 5;
        List<Cars> carsList = carService.getCars(carsCountInt);
        model.addAttribute("carsList", carsList);
        return "cars";
    }

}
