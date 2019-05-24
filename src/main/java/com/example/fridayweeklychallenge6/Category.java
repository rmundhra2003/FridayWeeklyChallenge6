package com.example.fridayweeklychallenge6;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String categoryName;

    @OneToMany(mappedBy = "category",
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    public Set<Car> cars;

    public Category() {
    }
    public Category(@NotNull @Size(min = 3) String categoryName, Set<Car> cars) {
        this.categoryName = categoryName;
        this.cars = cars;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
