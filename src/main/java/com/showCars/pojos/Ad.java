package com.showCars.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "AD")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @JsonIgnore
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private int idUser;
    @Column
    private int photo;
    @Column
    private int price;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private int year;
    @Column
    private String description;

    public Ad(int id, int idUser, int photo, int price, String make, String model, int year, String description) {
        this.id = id;
        this.idUser = idUser;
        this.photo = photo;
        this.price = price;
        this.make = make;
        this.model = model;
        this.year = year;
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {

        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
