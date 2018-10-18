package com.showCars.dao;

import java.util.List;

public interface IManufacturerDao<TYPE> extends IDao<TYPE> {

    List<TYPE> getAll() throws Exception;
}
