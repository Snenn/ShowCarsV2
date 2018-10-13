package com.showCars.services.daoImpl;


import com.showCars.dao.IUserDao;
import com.showCars.dao.IUserRoleDao;
import com.showCars.pojos.User;
import com.showCars.pojos.UserRole;
import com.showCars.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    private Logger logger = Logger.getLogger(UserService.class);
    private String messages;
    private User user;

    @Autowired
    IUserDao userDao;
    @Autowired
    IUserRoleDao userRoleDao;

    @Override
    public void saveOrUpdate(User user) throws Exception {
        try {
            /*Example handling exceptions*/
//            throw new Exception();

            userDao.saveOrUpdate(user);
            logger.info("user " + user.getLogin() + " created");

        } catch (Exception e) {
            logger.error("Error saveOrUpdate in UserService: " + e);
            throw new Exception(e);
        }
    }

    @Override
    public UserRole getRoleUser() throws Exception {
        return (UserRole) userRoleDao.get(1);
    }


    @Override
    public User findByLogin(String login) {
        return (User) userDao.findByLogin(login);
    }

    @Override
    public List getAll() throws Exception {
        return userDao.getAll();
    }

    @Override
    public int checkLoginPassword(String login, String password) {
        User user = (User) userDao.findByLogin(login);
        if (user == null) return 0;
        else {
            if (user.getPassword().equals(password)) return 1;
            else return 0;
        }

    }


}
