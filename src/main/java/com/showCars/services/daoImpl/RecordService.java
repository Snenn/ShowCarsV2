package com.showCars.services.daoImpl;


import com.showCars.dao.IRecordDao;
import com.showCars.pojos.Record;
import com.showCars.services.IRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordService implements IRecordService {



    private Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    IRecordDao recordDao;


    public void saveOrUpdate(Record record) throws Exception {
        try {
            recordDao.saveOrUpdate(record);
            logger.info("record id= " + record.getId() + " created");

        } catch (Exception e) {
            logger.error("Error saveOrUpdate in RecordService: " + e);
            throw new Exception(e);
        }
    }

    @Override
    public List getAll() throws Exception {
        return recordDao.getAll();
    }

}
