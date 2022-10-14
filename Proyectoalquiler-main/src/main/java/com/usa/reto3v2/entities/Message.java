package com.usa.reto3v2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
//@JsonIgnoreProperties({"motorbike","client"})
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    @Column(length = 250)
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "motorbikeId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})//ignorar mensaje y reservacion
    private Motorbike motorbike;
    @ManyToOne
    @JoinColumn(name = "client1")
    @JsonIgnoreProperties({"messages", "reservations"})//ignorar mensaje y reservacion
    private Client client;

    public Message() {
    }

    public Message(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
