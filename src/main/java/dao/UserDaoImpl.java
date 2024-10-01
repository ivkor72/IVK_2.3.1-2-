package dao;


import config.appConfig;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);

    private static final List<User> users = new ArrayList<>();
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Query query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
