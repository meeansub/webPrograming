package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Shippers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String company;




}
