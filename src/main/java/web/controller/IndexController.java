package web.controller;

import hiber.dao.UserDaoImpl;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {


    private UserService userService;

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("All users");
        model.addAttribute("messages", messages);
//        List<User> allUsers = userService.getUsers();
        return "index";
    }
}