package com.showCars.pojos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "USER")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Size(min = 1, max = 20, message = "Your name must be between 1 and 20 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+")
    private String surname;
    @Column
    @Size(min = 1, max = 20, message = "Your name must be between 1 and 20 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+")
    private String name;
    @Column
    @Size(min = 1, max = 20, message = "Your name must be between 1 and 20 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z0-9-_.]+")
    private String login;
    @Column
    @Size(min = 1, max = 20, message = "Your name must be between 1 and 20 characters long.")
    private String password;
    @ManyToOne
    @JoinColumn
    private UserRole userRole;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Ad> ads = new ArrayList();


}
