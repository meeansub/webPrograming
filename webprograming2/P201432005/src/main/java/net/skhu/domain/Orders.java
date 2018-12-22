package net.skhu.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	Date orderDate;
	Date shippedDate;

	String shipName;

	String shipAddress;
	String shipCity;
	String shipStateProvince;

	double shippingFee;
	String paymentType;
	Date paidDate;


	@ManyToOne
	@JoinColumn(name = "employee_id")
    Employees employees;

	@ManyToOne
	@JoinColumn(name = "customer_id")
    Customers customers;

	@ManyToOne
	@JoinColumn(name = "shipper_id")
	Shippers shippers;

}
