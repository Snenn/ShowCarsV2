package com.showCars.services;


import com.showCars.pojos.User;
import com.showCars.pojos.UserRole;

import java.util.List;

public interface IUserService {

    void saveOrUpdate(User user);

    UserRole getRoleUser() throws Exception;

    User findByLogin(String login);

    List getUsersLimit(int startNumber, int countFields);

    int getCountUsers();

    List getAll ();

    int checkLoginPassword (String login, String password );

}
