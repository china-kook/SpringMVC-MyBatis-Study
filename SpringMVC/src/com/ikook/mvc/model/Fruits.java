package com.ikook.mvc.model;

import com.ikook.mvc.validator.group.FruitsGroup1;
import com.ikook.mvc.validator.group.FruitsGroup2;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Fruits {

    private int id;
    @Size(min = 1,max = 20,message = "{fruits.name.length.error}", groups = {FruitsGroup1.class})
    private String name;
    private double price;
    @NotEmpty(message = "{fruits.producing_area.isEmpty}", groups = {FruitsGroup2.class})
    private String producing_area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducing_area() {
        return producing_area;
    }

    public void setProducing_area(String producing_area) {
        this.producing_area = producing_area;
    }
}
