package com.showCars.dao;

import java.util.List;

public interface IAdDao <TYPE> extends IDao<TYPE>  {

    List<TYPE> getAllWithFilters(String minYear, String maxYear, String minPrice, String maxPrice) throws Exception;

    List<TYPE> getAll() throws Exception;

    List<TYPE> getMyAd(int id) throws Exception;



}
