package com.showCars.services;


import com.showCars.dao.IDao;
import com.showCars.pojos.Ad;

import java.util.List;

public interface IAdService<TYPE> extends IDao<TYPE> {

    void saveOrUpdate(Ad ad);

    List getAll ();

    List getAllWithFilters (String minYear, String maxYear, String minPrice, String maxPrice);

}
