package com.example.tdddemo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CarSerive {

    private final CarRepository carRepository;

    public CarSerive(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Cacheable("cars")
    public Car getCarDetails(String name) throws CarNotFoundException{
        Car car = carRepository.findByName(name);

        if(car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }


}
