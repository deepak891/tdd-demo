package com.example.tdddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByName_returnCar() throws Exception {
        
       Car saveCar = entityManager.persistAndFlush(new Car("prius", "hybrid"));
       Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(saveCar.getName());
        assertThat(car.getType()).isEqualTo(saveCar.getType());
    }
}
