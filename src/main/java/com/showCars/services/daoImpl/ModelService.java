package com.showCars.services.daoImpl;

import com.showCars.dao.IModelDao;
import com.showCars.services.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModelService implements IModelService {


    @Autowired
    IModelDao modelDao;
    @Override
    public List getAll() throws Exception {
        return modelDao.getAll();
    }
}
