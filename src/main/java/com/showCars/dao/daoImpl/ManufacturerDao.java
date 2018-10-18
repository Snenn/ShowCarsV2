package com.showCars.dao.daoImpl;

import com.showCars.dao.IManufacturerDao;
import com.showCars.pojos.Manufacturer;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ManufacturerDao extends Dao<Manufacturer> implements IManufacturerDao<Manufacturer> {

    private static Logger logger = Logger.getLogger(ManufacturerDao.class);

    @Autowired
    public ManufacturerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Manufacturer> getAll() throws Exception {
        List result = null;
        try {
            Query query = getSession().createQuery("FROM Manufacturer order by name");
            result = query.list();
            logger.info("all Manufacturers:" + result);
        } catch (HibernateException e) {
            logger.error("Error get Manufacturers" + e);
            throw new Exception("Exception in ManufacturerDao getAll,  "+e);
        }
        return result;
    }
}
