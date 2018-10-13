package com.showCars.services;



import com.showCars.pojos.Record;

import java.util.List;

public interface IRecordService {

    List getAll () throws Exception;

    void saveOrUpdate(Record record) throws Exception;


}
