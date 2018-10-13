package com.showCars.dao.daoImpl;


import com.showCars.dao.IRecordDao;
import com.showCars.pojos.Record;
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
public class RecordDao extends Dao<Record> implements IRecordDao<Record> {

    private static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    public RecordDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public List<Record> getAll() throws Exception {
        List records = null;
        try {
            Query query = getSession().createQuery("FROM Record ");
            records = query.list();
            logger.info("all records:" + records);
        } catch (HibernateException e) {
            logger.error("Error get records" + e);
            throw new Exception("Exception in RecordDao getAll,  "+e);
        }
        return records;
    }


}
