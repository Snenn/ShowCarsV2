package com.showCars.dao.daoImpl;

import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Repository
public class AdDao extends Dao<Ad> implements IAdDao<Ad> {

    private static Logger logger = Logger.getLogger(AdDao.class);

    @Autowired
    public AdDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Ad> getAll() {
        List ads = null;
        try {
            Query query = getSession().createQuery("FROM Ad ");
            ads = query.list();
            logger.info("all users:" + ads);
        } catch (HibernateException e) {
            logger.error("Error get users" + e);
        }
        return ads;
    }

    @Override
    public List<Ad> getAllWithFilters(String minYear, String maxYear, String minPrice, String maxPrice) {
        int minYearQuery = 0;
        int maxYearQuery = 2050;
        int minPriceQuery = 0;
        int maxPriceQuery = 10000000;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        if (!Objects.equals(minYear, "") && minYear.matches(regex)) {
            minYearQuery = Integer.parseInt(minYear);
        }
        if (!Objects.equals(maxYear, "") && maxYear.matches(regex)) {
            maxYearQuery = Integer.parseInt(maxYear);
        }
        if (!Objects.equals(minPrice, "") && minPrice.matches(regex)) {
            minPriceQuery = Integer.parseInt(minPrice);
        }
        if (!Objects.equals(maxPrice, "") && maxPrice.matches(regex)) {
            maxPriceQuery = Integer.parseInt(maxPrice);
        }

        List ads = null;
        try {
            Query query = getSession().createQuery("FROM Ad where price >= :minPriceQuery and price <= :maxPriceQuery and year >= :minYearQuery and year <= :maxYearQuery ");
            query.setParameter("minPriceQuery", minPriceQuery);
            query.setParameter("maxPriceQuery", maxPriceQuery);
            query.setParameter("minYearQuery", minYearQuery);
            query.setParameter("maxYearQuery", maxYearQuery);
            ads = query.list();
        } catch (HibernateException e) {
            logger.error(e);
        }
        return ads;
    }

    @Override
    public List<Ad> getAllLimit(int startNumber, int endNumber) {
        return null;
    }

}
