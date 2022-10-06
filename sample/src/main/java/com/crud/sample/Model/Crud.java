package com.crud.sample.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Crud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String birthday;
    private Long age;
    private String address;
    private String vehicle;
    private String gasoline;
    private Long liters;
    private Long price;

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getfirst_name(){
        return first_name;
    }
    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getmiddle_name(){
        return middle_name;
    }
    public void setmiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }
    public String getlast_name(){
        return last_name;
    }
    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getbirthday(){
        return birthday;
    }
    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }
    public Long getage(){
        return age;
    }
    public void setage(Long age) {
        this.age = age;
    }
    public String getaddress(){
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public String getvehicle(){
        return vehicle;
    }
    public void setvehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public String getgasoline(){
        return gasoline;
    }
    public void setgasoline(String gasoline) {
        this.gasoline = gasoline;
    }
    public Long getliters(){
        return liters;
    }
    public void setliters(Long liters) {
        this.liters = liters;
    }
    public Long getprice(){
        return price;
    }
    public void setprice(Long price) {
        this.price = price;
    }
}
