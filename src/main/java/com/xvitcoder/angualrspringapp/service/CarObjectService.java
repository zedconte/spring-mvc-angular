package com.xvitcoder.angualrspringapp.service;

import com.xvitcoder.angualrspringapp.beans.Car;
import com.xvitcoder.angualrspringapp.beans.Train;

import java.util.List;

/**
 * Created by raul.ortega on 6/6/2014.
 */
public interface CarObjectService {
    public List<Car> getAllCars();

    public Car getCarById(Long id);

    public void addCar(Car car);

    public void deleteCarById(Long id);

    public void deleteAll();

    public void updateCar(Car car);
}
