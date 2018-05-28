package com.example.tdddemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private CarSerive carSerive;

    public CarController(CarSerive carService) {
        this.carSerive = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carSerive.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {}
}
