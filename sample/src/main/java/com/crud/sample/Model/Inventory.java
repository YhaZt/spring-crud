package com.crud.sample.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gasoline;
    private Long price;
    private Long liters;

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getgasoline(){
        return gasoline;
    }
    public void setgasoline(String gasoline) {
        this.gasoline = gasoline;
    }
    public Long getprice(){
        return price;
    }
    public void setprice(Long price) {
        this.price = price;
    }
    public Long getliters(){
        return liters;
    }
    public void setliters(Long liters) {
        this.liters = liters;
    }

}
