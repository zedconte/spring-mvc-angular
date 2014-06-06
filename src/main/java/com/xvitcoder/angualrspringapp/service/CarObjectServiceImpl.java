package com.xvitcoder.angualrspringapp.service;

import com.xvitcoder.angualrspringapp.beans.Car;
import com.xvitcoder.angualrspringapp.beans.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raul.ortega on 6/6/2014.
 */
@Service("carService")
public class CarObjectServiceImpl implements CarObjectService{
    private static List<Car> carList = new ArrayList<Car>();
    private static Long id = 0L;

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public Car getCarById(Long id) {
        return findCarById(id);
    }

    @Override
    public void addCar(Car car) {
        car.setId(++id);
        carList.add(car);
    }

    @Override
    public void deleteCarById(Long id) {
        Car foundCar = findCarById(id);
        if (foundCar != null) {
            carList.remove(foundCar);
            id--;
        }
    }

    @Override
    public void deleteAll() {
        carList.clear();
        id = 0L;
    }

    @Override
    public void updateCar(Car car) {
        Car foundCar = findCarById(car.getId());
        if (foundCar != null) {
            carList.remove(foundCar);
            carList.add(car);
        }
    }

    private Car findCarById(Long id) {
        for (Car car : carList) {
            if (car.getId() == id) {
                return car;
            }
        }

        return null;
    }
}
