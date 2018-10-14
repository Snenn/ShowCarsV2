package com.showCars.services.daoImpl;

import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import com.showCars.services.IAdService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AdService implements IAdService {

    private Logger logger = Logger.getLogger(AdService.class);


    @Autowired
    IAdDao adDao;

    @Override
    public void saveOrUpdate(Ad ad) throws Exception {
        try {

            adDao.saveOrUpdate(ad);
            logger.info("ad created");

        } catch (Exception e) {
            logger.error("Error saveOrUpdate in AdService: " + e);
            throw new Exception(e);
        }
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
    public List getMyAd(int id) throws Exception {
        return adDao.getMyAd(id);
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
