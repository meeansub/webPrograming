package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="last_name")
    String lastName;

    @Column(name = "first_name")
    String firstName;


}
