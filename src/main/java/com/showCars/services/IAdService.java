package com.showCars.services;


import com.showCars.dao.IDao;
import com.showCars.pojos.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IAdService<TYPE> extends IDao<TYPE> {

    void saveOrUpdate(User user, String make, String model,
                      String price, String year, String description, MultipartFile photo) throws Exception;

    List getAllWithFilters (String minYear, String maxYear, String minPrice, String maxPrice, String make, String model) throws Exception;

    List getAll () throws Exception;

    List getMyAd (int id) throws Exception;


}
