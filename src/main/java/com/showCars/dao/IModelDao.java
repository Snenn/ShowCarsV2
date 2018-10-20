package com.showCars.dao;


import java.util.List;

public interface IModelDao <TYPE> extends IDao<TYPE> {

    List<TYPE> getAll() throws Exception;

    List<TYPE> getModelsByFirstManufacturers() throws Exception;

}
