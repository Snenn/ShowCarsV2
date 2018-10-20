package com.showCars.dao.daoImpl;

import com.showCars.dao.IModelDao;
import com.showCars.pojos.Manufacturer;
import com.showCars.pojos.Model;
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
public class ModelDao extends Dao<Model> implements IModelDao<Model> {

    private static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    public ModelDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Model> getAll() throws Exception {
        List models = null;
        try {
            Query query = getSession().createQuery("FROM Model order by name");
            models = query.list();
            logger.info("all models:" + models);
        } catch (HibernateException e) {
            logger.error("Error get models" + e);
            throw new Exception("Exception in ModelDao getAll,  "+e);
        }
        return models;
    }

    @Override
    public List<Model> getModelsByFirstManufacturers() throws Exception {
        List models = null;

        try {
            Query query1 = getSession().createQuery("FROM Manufacturer order by name");
            query1.setMaxResults (1);
            Manufacturer manufacturer = (Manufacturer) query1.uniqueResult();
            Query query = getSession().createQuery("FROM Model where manufacturer_id=:idM  order by name");
            query.setParameter("idM", manufacturer.getId());
            models = query.list();
            logger.info("all models:" + models);
        } catch (HibernateException e) {
            logger.error("Error get models" + e);
            throw new Exception("Exception in ModelDao getAll,  "+e);
        }
        return models;
    }


}
