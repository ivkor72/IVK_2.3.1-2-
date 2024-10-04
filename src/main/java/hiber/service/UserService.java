package hiber.service;


import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {


    List<User> getUsers();
}
