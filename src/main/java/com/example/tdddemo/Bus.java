package com.example.tdddemo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bus {
    private Long id;
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
