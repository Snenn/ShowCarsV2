package com.showCars.dao;

import java.util.List;

public interface IAdDao <TYPE> extends IDao<TYPE>  {

    List<TYPE> getAll() ;

    List<TYPE> getAllWithFilters(String minYear, String maxYear, String minPrice, String maxPrice);

    List<TYPE> getAllLimit(int startNumber, int endNumber) ;
}
