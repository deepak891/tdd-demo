package com.example.tdddemo;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository  extends CrudRepository<Car,Long>{
    Car findByName(String name);


}
