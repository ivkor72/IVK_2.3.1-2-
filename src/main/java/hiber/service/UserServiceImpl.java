package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImpl;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();




    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }


}
