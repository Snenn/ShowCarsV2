package com.showCars.dao.daoImpl;

import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AdDao extends Dao<Ad> implements IAdDao<Ad> {

    private static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    public AdDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<Ad> getAll() {
        List ads = null;
        try {
            System.out.println("go in dao");
            Query query = getSession().createQuery("FROM Ad ");
            ads = query.list();
            logger.info("all users:" + ads);
        } catch (HibernateException e) {
            logger.error("Error get users" + e);
        }
        System.out.println("get from bd: "+ads);
        return ads;
    }

    @Override
    public List<Ad> getAllLimit(int startNumber, int endNumber) {
        return null;
    }

}
