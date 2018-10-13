package com.showCars.dao;

import java.util.List;


public interface IUserDao<TYPE> extends IDao<TYPE> {

    List<TYPE> getAll() throws Exception;

    TYPE findByLogin(String login);

}
