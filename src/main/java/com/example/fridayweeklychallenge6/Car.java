package com.example.fridayweeklychallenge6;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String carName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    @NotNull
    @Size(min=3)
    private String manufacturer;

    @NotNull
    @Size(min=3)
    private String model;

    @NotNull
    @Size(min=3)
    private String year;

    @NotNull
    @Size(min=3)
    private String msrp;

    public Car() {
    }

    public Car(@NotNull @Size(min = 3) String carName, Category category, @NotNull @Size(min = 3) String manufacturer, @NotNull @Size(min = 3) String model, @NotNull @Size(min = 3) String year, @NotNull @Size(min = 3) String msrp) {
        this.carName = carName;
        this.category = category;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.msrp = msrp;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }
}
