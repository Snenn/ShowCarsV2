package com.showCars.dao;


import java.util.List;

public interface IUserRoleDao<TYPE> extends IDao<TYPE> {
    List getAll();
}
