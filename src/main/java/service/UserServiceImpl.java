package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();




    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }


}
