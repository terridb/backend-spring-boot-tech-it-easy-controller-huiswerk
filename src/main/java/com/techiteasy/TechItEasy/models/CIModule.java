//package com.techiteasy.TechItEasy.models;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "ci_modules")
//public class CIModule {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String type;
//    private Double price;
//
//    @OneToMany(mappedBy = "ciModule")
//    List<CIModule> televisions;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public List<CIModule> getTelevisions() {
//        return televisions;
//    }
//
//    public void setTelevisions(List<CIModule> televisions) {
//        this.televisions = televisions;
//    }
//}
