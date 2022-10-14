package com.usa.reto3v2.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "motorbike")// Creacion de tabla
public class Motorbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //atributos de tabla
    private Integer id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String brand;

    //@Column(name="'year'")
    private Integer year;
    @Column(length = 250)
    private String description;
    //Relaciones con tablas
    @ManyToOne//Relación de muchos a uno
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("motorbikes")
    private Category category;

    @OneToMany(mappedBy = "motorbike", cascade = {CascadeType.PERSIST})//Relación de uno a muchos con Message
    @JsonIgnoreProperties({"motorbike", "client"})
    private List<Message> messages;
    @OneToMany(mappedBy = "motorbike", cascade = {CascadeType.PERSIST})//Relación de uno a muchos con Reservation
    @JsonIgnoreProperties({"motorbike", "message"})
    private List<Reservation> reservations;


    //Constructor

    public Motorbike() {
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Motorbike(Integer id) {
        this.id = id;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Integer getId() {
        return id;
    }

    public Motorbike(Integer id, String brand, String name, Integer year, String description, Category category) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.year = year;
        this.description = description;
        this.category = category;
    }

    //getters y seters
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
