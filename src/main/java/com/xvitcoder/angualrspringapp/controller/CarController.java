package com.xvitcoder.angualrspringapp.controller;

import com.xvitcoder.angualrspringapp.beans.Car;
import com.xvitcoder.angualrspringapp.service.CarObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarObjectService carService;

    @RequestMapping("/carlist.json")
    public @ResponseBody List<Car> getCarList() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/addCar/{car}", method = RequestMethod.POST)
    public @ResponseBody void addCar(@RequestBody Car car) { carService.addCar(car);    }

    @RequestMapping(value = "/updateCar/{car}", method = RequestMethod.PUT)
    public @ResponseBody void updateCar(@RequestBody Car car) { carService.updateCar(car);    }

    @RequestMapping(value = "/removeCar/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeCar(@PathVariable("id") Long id) {
        carService.deleteCarById(id);
    }

    @RequestMapping(value = "/removeAllCars", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllCars() {
        carService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getCarPartialPage(ModelMap modelMap) {
        return "cars/layout";
    }
}
