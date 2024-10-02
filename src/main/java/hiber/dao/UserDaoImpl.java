package hiber.dao;


import hiber.config.appConfig;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
//@Autowired
//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);

    //private static final List<User> users = new ArrayList<>();
//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> getUsers() {

        return em.createQuery("from User", User.class).getResultList();
    }
}
