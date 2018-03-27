package com.showCars.dao;

import java.util.List;

public interface IDao<Type> {

List<Type> getAll();

void save(Type type);

}
