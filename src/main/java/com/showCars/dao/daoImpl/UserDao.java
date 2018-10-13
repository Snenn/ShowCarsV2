package com.showCars.dao.daoImpl;


import com.showCars.dao.IUserDao;
import com.showCars.pojos.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao extends Dao<User> implements IUserDao<User> {

    private static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<User> getAll() throws Exception {
        List users = null;
        try {
            Query query = getSession().createQuery("FROM User ");
            users = query.list();
            logger.info("all users:" + users);
        } catch (HibernateException e) {
            logger.error("Error get users" + e);
            throw new Exception("Exception in Userado getAll,  "+e);
        }
        return users;
    }


    public User findByLogin(String login) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }


}
