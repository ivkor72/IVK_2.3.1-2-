package hiber.dao;


import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    public AnnotationConfigApplicationContext getContext() {
        return context;
    }

    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public List<User> getUsers() {

        return em.createQuery("from User", User.class).getResultList();
    }
}
