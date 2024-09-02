package web.controller;

import model.Cars;
import org.springframework.stereotype.Controller;
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
    public String Cars(ModelMap model) {
        List<Cars> carsList = carService.getCars(7);
        model.addAttribute("carsList", carsList);

        return "cars";
    }


}
