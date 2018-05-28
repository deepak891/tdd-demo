package com.example.tdddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    private CarSerive serive;

    @MockBean
    private CarRepository repository;

    @Test
    public void caching() throws Exception {
        given(repository.findByName(anyString())).willReturn(new Car("prius","hybrid"));

        serive.getCarDetails("prius");
        serive.getCarDetails("prius");

        verify(repository, times(1)).findByName("prius");
    }
}
