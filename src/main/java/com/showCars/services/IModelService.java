package com.showCars.services;


import java.util.List;

public interface IModelService {

    List getAll() throws Exception;

    List getModelsByFirstManufacturers() throws Exception;

}
