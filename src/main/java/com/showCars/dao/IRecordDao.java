package com.showCars.dao;


import java.util.List;

public interface IRecordDao<TYPE> extends IDao<TYPE> {

    List<TYPE> getAll() throws Exception;
}