package com.showCars.dao.daoImpl;


import com.showCars.dao.IUserRoleDao;
import com.showCars.pojos.UserRole;
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
public class UserRoleDao extends Dao<UserRole> implements IUserRoleDao<UserRole> {

        private static Logger logger = Logger.getLogger(UserRoleDao.class);


    @Autowired
    public UserRoleDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List getAll() throws Exception {
        List userRoles = null;
        try {
            Query query = getSession().createQuery("FROM userrole ");
            userRoles = query.list();
            logger.info("all userRoles:" + userRoles);
        } catch (HibernateException e) {
            logger.error("Error get userRoles" + e);
            throw new Exception("Exception in UserRoleDao.getAll, "+e);
        }
        return userRoles;
    }
}
