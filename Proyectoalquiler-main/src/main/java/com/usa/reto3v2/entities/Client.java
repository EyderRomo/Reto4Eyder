package com.usa.reto3v2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    @Column(length = 250)
    private String name;
    private Integer age;

//arreglo de messages en client

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("client")//ignorar cliente
    private List<Message> messages;
    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("client")//ignorar cliente
    private List<Reservation> reservations;


    public Client() {
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Client(Integer id, String name, String email, String password, Integer age) {
        this.idClient = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
