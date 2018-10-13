package com.showCars.services;


import com.showCars.pojos.User;
import com.showCars.pojos.UserRole;

import java.util.List;

public interface IUserService {

    void saveOrUpdate(User user) throws Exception;

    UserRole getRoleUser() throws Exception;

    User findByLogin(String login);

    List getAll () throws Exception;

    int checkLoginPassword (String login, String password );

}
