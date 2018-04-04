package com.showCars.dao;

import java.util.List;

public interface IAdDao <TYPE> extends IDao<TYPE>  {

    List<TYPE> getAll() ;

    List<TYPE> getAllLimit(int startNumber, int endNumber) ;
}
