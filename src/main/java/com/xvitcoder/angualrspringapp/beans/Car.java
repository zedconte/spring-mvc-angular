package com.xvitcoder.angualrspringapp.beans;

/**
 * Created by raul.ortega on 6/6/2014.
 */
public class Car {
    private Long id;
    private String name;
    private String cylinders;

    public Car() {

    }

    public Car(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCylinders() {
        return cylinders;
    }

    public void setCylinders(String cylinders) {
        this.cylinders = cylinders;
    }
}
