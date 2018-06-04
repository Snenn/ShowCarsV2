package com.showCars.services.daoImpl;
import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import com.showCars.services.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class AdService implements IAdService {

    @Autowired
    IAdDao adDao;

    @Override
    public void saveOrUpdate(Ad ad) {

    }

    @Override
    public List getAll() {
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
