package hiber.dao;


import hiber.config.appConfig;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager em;

@Transactional
    @Override
    public List<User> getUsers() {

        return em.createQuery("from User", User.class).getResultList();
    }
}
