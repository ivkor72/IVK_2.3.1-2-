package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {



    List<User> getUsers();
}
