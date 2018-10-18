package com.showCars.services.daoImpl;

import com.showCars.dao.IManufacturerDao;
import com.showCars.services.IManufacturerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManufacturerService implements IManufacturerService {
    private Logger logger = Logger.getLogger(UserService.class);


    @Autowired
    IManufacturerDao manufacturerDao;
    @Override
    public List getAll() throws Exception {
        return manufacturerDao.getAll();
    }
}
