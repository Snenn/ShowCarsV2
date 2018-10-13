package com.showCars.services.daoImpl;
import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import com.showCars.services.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AdService implements IAdService {

    @Autowired
    IAdDao adDao;

    @Override
    public void saveOrUpdate(Ad ad) {

    }

    @Override
    public List getAllWithFilters(String minYear, String maxYear, String minPrice, String maxPrice) throws Exception {
        return adDao.getAllWithFilters(minYear, maxYear, minPrice, maxPrice);
    }

    @Override
    public List getAll() throws Exception {
        return adDao.getAll();
    }

    @Override
    public void saveOrUpdate(Object o) throws Exception {

    }

    @Override
    public void delete(Object o) throws Exception {

    }

    @Override
    public Object get(Serializable id) throws Exception {
        return null;
    }
}
