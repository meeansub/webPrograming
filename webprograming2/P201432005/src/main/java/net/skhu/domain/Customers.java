package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;


	String company;

	String lastName;

	String firstName;

	String jobTitle;

	String address;

	String city;

	String stateProvince;

	String businessPhone;

	@OneToMany(mappedBy = "customers")
	List<Orders> orders;
}
