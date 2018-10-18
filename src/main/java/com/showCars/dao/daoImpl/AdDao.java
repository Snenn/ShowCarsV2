package com.showCars.dao.daoImpl;

import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Repository
@Transactional
public class AdDao extends Dao<Ad> implements IAdDao<Ad> {

    private static Logger logger = Logger.getLogger(AdDao.class);

    @Autowired
    public AdDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Ad> getAllWithFilters(String minYear, String maxYear, String minPrice, String maxPrice, String make, String model) throws Exception {

        int minYearQuery = 0;
        int maxYearQuery = 2050;
        int minPriceQuery = 0;
        int maxPriceQuery = 10000000;
        String regex = "\\d+";
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
        String sql = "";
        logger.error("sql : "+sql);
        if (model.equals("any")) {
            if (make.equals("any")) {
                sql = "FROM Ad where price >= :minPriceQuery and price <= :maxPriceQuery " +
                        "and year >= :minYearQuery and year <= :maxYearQuery order by id desc ";
            } else {
                sql = "FROM Ad where price >= :minPriceQuery and price <= :maxPriceQuery " +
                        "and year >= :minYearQuery and year <= :maxYearQuery and make = :make order by id desc ";
            }
        } else {
            sql = "FROM Ad where price >= :minPriceQuery and price <= :maxPriceQuery " +
                    "and year >= :minYearQuery and year <= :maxYearQuery and make = :make and model = :model order by id desc ";
        }

        try {
            Query query = getSession().createQuery(sql);
            query.setParameter("minPriceQuery", minPriceQuery);
            query.setParameter("maxPriceQuery", maxPriceQuery);
            query.setParameter("minYearQuery", minYearQuery);
            query.setParameter("maxYearQuery", maxYearQuery);
            if (!make.equals("any")) {
                query.setParameter("make", make);
            }
            if (!model.equals("any")) {
                query.setParameter("model", model);
            }
            ads = query.list();
        } catch (HibernateException e) {
            logger.error("Exception in getAllWithFilters, " + e);
            throw new Exception();
        }
        return ads;
    }

    @Override
    public List<Ad> getAll() throws Exception {
        List ads = null;
        try {
            Query query = getSession().createQuery("FROM Ad");
            ads = query.list();
        } catch (HibernateException e) {
            logger.error("Exception in getAllAd, " + e);
            throw new Exception();
        }
        return ads;
    }

    @Override
    public List<Ad> getMyAd(int id) throws Exception {
        List ads = null;
        try {
            Query query = getSession().createQuery("from Ad where user.id=:id order by id desc");
            query.setParameter("id", id);
            ads = query.list();
        } catch (HibernateException e) {
            logger.error("Exception in getMyAd, " + e);
            throw new Exception();
        }
        return ads;
    }

}
